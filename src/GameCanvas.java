import bases.GameObject;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import sun.awt.image.PixelConverter;
import touhou.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import static java.awt.event.KeyEvent.*;

public class GameCanvas extends JPanel {


    BufferedImage backBuffer;
    Graphics backGraphics;
    Player player = new Player();
    Enemies enemies = new Enemies();
    BackGround backGround = new BackGround();
    GameWindow window;


    public GameCanvas(GameWindow window) {
        this.window = window;
        //1.Create a back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        GameObject.add(player);
        GameObject.add(enemies);

        //1.Load Background


    }

    public void render() {
        //1.Draw everything on back buffer

        backGround.render(backGraphics);
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
        if(player.hitBox().intersects(enemies.hitBox())){
            GameObject.remove(player);
            System.exit(0);
        }

    }

}


