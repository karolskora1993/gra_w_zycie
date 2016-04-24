/**
 * Created by apple on 24.04.2016.
 */
public class GameThread extends Thread {

    private GameOfLife gameOfLife;
    private GameComponent gameComponent;


    public GameThread(GameOfLife gameOfLife, GameComponent gameComponent){
        this.gameComponent=gameComponent;
        this.gameOfLife=gameOfLife;
    }

    public void run(){

        while(gameOfLife.isStarted()){

            gameOfLife.nextRound();
            gameComponent.repaint();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
