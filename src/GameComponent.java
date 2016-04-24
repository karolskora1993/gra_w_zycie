import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by apple on 24.04.2016.
 */
public class GameComponent extends JComponent {
    private int x=50;
    private int y=50;


    private int rectSize;

    private GameOfLife gameOfLife;

    public GameComponent(GameOfLife gameOfLife){

        this.rectSize=800/x;
        this.gameOfLife=gameOfLife;
        addMouseListener(new EventHandler());
    }



    public void paintComponent(Graphics g) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (gameOfLife.isAlive(i,j)==1) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(rectSize * j, rectSize * i, rectSize, rectSize);
            }
        }
    }

    class EventHandler extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {

            int y=e.getX();
            int x=e.getY();

            int i=x/rectSize;
            int j=y/rectSize;

            System.out.println("i: "+ i +" j:"+j);

            gameOfLife.setAlive(i,j);
            GameComponent.this.repaint();

        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }
}

