/**
 * Created by apple on 24.04.2016.
 */
public class GameOfLife {

    private boolean[][] tab=new boolean[30][30];
    private int x=30;
    private int y=30;
    private boolean period=false;
    private boolean started=false;

    public GameOfLife(){
        for(int i=0; i<x;i++){
            for(int j=0;j<30;j++){
                this.tab[i][j]=false;
            }
        }
    }

    public void generateGilder() {

        tab[20][20]=true;
        tab[20][21]=true;
        tab[20][22]=true;
        tab[21][20]=true;
        tab[22][21]=true;


    }
    public void generateConst() {

        tab[20][20]=true;
        tab[20][21]=true;
        tab[21][20]=true;
        tab[21][21]=true;


    }
    public void generateOscillator() {
        for(int i=10; i<20 ;i++){
            this.tab[15][i]=true;
        }
    }

    public void clear(){
        for(int i=0; i<x;i++){
            for(int j=0;j<30;j++){
                this.tab[i][j]=false;
            }
        }
    }


    public boolean isPeriod() {
        return period;
    }

    public void setPeriod(boolean period) {
        this.period = period;

        System.out.println("Periodyczne: "+period);
    }

    public void setAlive(int x, int y){
        if(this.tab[x][y])
            this.tab[x][y]=false;
        else
            this.tab[x][y]=true;


    }

    public int isAlive(int x, int y){
        if(tab[x][y])
            return 1;
        else
        return 0;

    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void start(){
        this.started=true;
    }
    public void stop(){
        this.started=false;
    }


    public void nextRound() {

        System.out.println("nastepna runda");
        boolean[][] tmp = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tab[i][j]) {
                    if (sasiad(i, j) == 3 || sasiad(i, j) == 2) {
                        tmp[i][j] = true;
                    } else {
                        tmp[i][j] = false;
                    }

                } else {
                    if (sasiad(i, j) == 3) {
                        tmp[i][j] = true;
                    }
                }
            }
        }

        tab = tmp;
    }

    private int sasiad(int i, int j) {
        int s = 0;
        if (period) {
            s += tab[(i - 1)<0?x-1:(i - 1)][(j - 1)<0?y-1:(j - 1)] ? 1 : 0;
            s += tab[(i - 1)<0?x-1:(i - 1)][j] ? 1 : 0;
            s += tab[(i - 1)<0?x-1:(i - 1)][(j + 1)%y] ? 1 : 0;
            s += tab[i][(j - 1)<0?y-1:(j - 1)] ? 1 : 0;
            s += tab[i][(j + 1)%y] ? 1 : 0;
            s += tab[(i + 1)%x][(j - 1)<0?y-1:(j - 1)] ? 1 : 0;
            s += tab[(i + 1)%x][j] ? 1 : 0;
            s += tab[(i + 1)%x][(j + 1)%y] ? 1 : 0;
        } else {
            if (j == 0) {
                if (i == 0) {
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                    s += tab[i + 1][j + 1] ? 1 : 0;
                } else if (i == x - 1) {
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i - 1][j + 1] ? 1 : 0;

                } else {
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i - 1][j + 1] ? 1 : 0;
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                    s += tab[i + 1][j + 1] ? 1 : 0;
                }
            } else if (j == y - 1) {
                if (i == 0) {
                    s += tab[i + 1][j - 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                    s += tab[i][j - 1] ? 1 : 0;
                } else if (i == x - 1) {
                    s += tab[i - 1][j - 1] ? 1 : 0;
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i][j - 1] ? 1 : 0;
                } else {
                    s += tab[i - 1][j - 1] ? 1 : 0;
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i][j - 1] ? 1 : 0;
                    s += tab[i + 1][j - 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                }
            } else {
                if (i == 0) {
                    s += tab[i][j - 1] ? 1 : 0;
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i + 1][j - 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                    s += tab[i + 1][j + 1] ? 1 : 0;
                } else if (i == x - 1) {
                    s += tab[i][j - 1] ? 1 : 0;
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i - 1][j - 1] ? 1 : 0;
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i - 1][j + 1] ? 1 : 0;
                } else {
                    s += tab[i - 1][j - 1] ? 1 : 0;
                    s += tab[i - 1][j] ? 1 : 0;
                    s += tab[i - 1][j + 1] ? 1 : 0;
                    s += tab[i][j - 1] ? 1 : 0;
                    s += tab[i][j + 1] ? 1 : 0;
                    s += tab[i + 1][j - 1] ? 1 : 0;
                    s += tab[i + 1][j] ? 1 : 0;
                    s += tab[i + 1][j + 1] ? 1 : 0;
                }
            }
        }
        return s;

    }
}
