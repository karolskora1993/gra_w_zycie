/**
 * Created by apple on 24.04.2016.
 */
public class GameOfLife {

    private int x=50;
    private int y=50;
    private boolean[][] tab=new boolean[x][y];
    private boolean period=false;
    private boolean started=false;

    public GameOfLife(){
        for(int i=0; i<x;i++){
            for(int j=0;j<y;j++){
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

    public void generateOscillator2() {
        tab[15][15]=true;
        tab[15][16]=true;
        tab[15][17]=true;
    }

    public void generateGliderGun(){
        tab[5][1]=true;
        tab[5][2]=true;
        tab[6][1]=true;
        tab[6][2]=true;
        tab[3][13]=true;
        tab[3][14]=true;
        tab[4][12]=true;
        tab[5][11]=true;
        tab[6][11]=true;
        tab[7][11]=true;
        tab[8][12]=true;
        tab[9][13]=true;
        tab[9][14]=true;
        tab[8][16]=true;
        tab[7][17]=true;
        tab[6][17]=true;
        tab[5][17]=true;
        tab[6][18]=true;
        tab[4][16]=true;
        tab[3][21]=true;
        tab[3][22]=true;
        tab[4][21]=true;
        tab[4][22]=true;
        tab[5][21]=true;
        tab[5][22]=true;
        tab[6][23]=true;
        tab[6][25]=true;
        tab[7][25]=true;
        tab[1][25]=true;
        tab[2][25]=true;
        tab[3][35]=true;
        tab[3][36]=true;
        tab[4][35]=true;
        tab[4][36]=true;
        tab[6][15]=true;
        tab[2][23]=true;



    }

    public void clear(){
        for(int i=0; i<x;i++){
            for(int j=0;j<y;j++){
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
