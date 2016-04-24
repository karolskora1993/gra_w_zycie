import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by apple on 24.04.2016.
 */
public class Frame extends JFrame {

    public static final int WIDTH=900;
    public static final int HEIGHT=900;

    private GameOfLife gameOfLife;

    private GameComponent gameComponent;
    private JPanel settingsPanel;



    public Frame(GameOfLife gameOfLife){
        this.gameOfLife=gameOfLife;
        initializeComponent();
    }
    private void initializeComponent(){

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());

        settingsPanel=new JPanel();

        JButton buttonGlider=new JButton("glider");
        buttonGlider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.generateGilder();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonGlider);

        JButton buttonGliderGun=new JButton("glider gun");
        buttonGliderGun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.generateGliderGun();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonGliderGun);

        JButton buttonConst=new JButton("stałe");
        buttonConst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.generateConst();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonConst);

        JButton buttonOscillator=new JButton("oscylator");
        buttonOscillator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.generateOscillator();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonOscillator);

        JButton buttonOscillator2=new JButton("oscylator-2");
        buttonOscillator2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.generateOscillator2();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonOscillator2);

        JButton buttonClear=new JButton("wyczyść");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.gameOfLife.clear();
                gameComponent.repaint();
            }
        });
        settingsPanel.add(buttonClear);

        JButton buttonPeriod=new JButton("włącz periodyczne");
        buttonPeriod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b=(JButton)e.getSource();
                if(Frame.this.gameOfLife.isPeriod()) {
                    b.setText("włącz periodyczne");
                    Frame.this.gameOfLife.setPeriod(false);
                }
                else{
                    b.setText("wyłącz periodyczne");
                    Frame.this.gameOfLife.setPeriod(true);
                }
            }
        });
        settingsPanel.add(buttonPeriod);

        JButton buttonStart=new JButton("START");
        buttonStart.addActionListener(new ButtonStartListener());
        settingsPanel.add(buttonStart);

        add(settingsPanel, BorderLayout.NORTH);

        gameComponent=new GameComponent(gameOfLife);

        add(gameComponent, BorderLayout.CENTER);

    }


    class ButtonStartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            JButton b=(JButton)e.getSource();

            if(Frame.this.gameOfLife.isStarted()){
                b.setText("START");
                gameOfLife.stop();
            }
            else
            {
                gameOfLife.start();
                GameThread t=new GameThread(gameOfLife, gameComponent);
                t.start();
                b.setText("STOP");
            }


        }
    }
}

