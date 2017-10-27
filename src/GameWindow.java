import touhou.inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas canvas;
    long lasTimeUpade ;
    boolean check = true;

    public GameWindow() {
        this.setSize(800, 600);

        this.setBackground(Color.black);

        this.canvas = new GameCanvas(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                InputManager.instance.keyPressed(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.keyReleased(e);
            }
        });

        this.setContentPane(canvas);
        this.canvas.setVisible(true);
        this.setVisible(true);
        lasTimeUpade = System.nanoTime();
    }

    public void GameLoop() {
        while (check) {
            long currentTime =System.nanoTime();
            if ( currentTime - lasTimeUpade >= 17000000){
                canvas.run();
                canvas.render();
                lasTimeUpade =  currentTime;
            }

        }
    }

    public void endGame (){
        check = false;
        System.exit(0);
    }
}

