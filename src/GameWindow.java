import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow (){
        this.setSize(800,600);

        this.setBackground(Color.black);

        this.canvas = new GameCanvas();

       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });


//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(canvas);
        //mẹ visible trước - canvas là mẹ
        this.canvas.setVisible(true);
        //con visible sau - window là con
        this.setVisible(true);
    }

    }

