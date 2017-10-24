import bases.GameObject;
import touhou.*;
import touhou.enemies.Enemies;
import touhou.enemies.EnemySpawner;
import touhou.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {


    BufferedImage backBuffer;
    Graphics backGraphics;
    Player player = new Player();
    BackGround backGround = new BackGround();
    GameWindow window;


    public GameCanvas(GameWindow window) {
        this.window = window;
        //1.Create a back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        GameObject.add(backGround);
        GameObject.add(player);
        GameObject.add(new EnemySpawner());


        //1.Load Background


    }

    public void render() {
        //1.Draw everything on back buffer
        GameObject.renderAll(backGraphics);
        //2. Call repaint
        repaint();
    }
    //2. Draw background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);

    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);


    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }


    public void run() {
        GameObject.runAll();


    }

}


