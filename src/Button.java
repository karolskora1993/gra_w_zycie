import javax.swing.*;
import java.awt.*;

/**
 * Created by apple on 24.04.2016.
 */
public class Button extends JButton {

    private int x;
    private int y;
    private boolean alive=false;
    Dimension size;

    public Button(int x, int y, Dimension size){
        super();
        this.x=x;
        this.y=y;
        this.size=size;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }
    public void setAlive(boolean alive){
        this.alive=alive;
    }

    public void paintComponent(Graphics g) {

        if(alive)
            g.setColor(Color.WHITE);
        else
            g.setColor(Color.BLACK);

        g.fillRect(0, 0, getSize().width, getSize().height);
    }
}
