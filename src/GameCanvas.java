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

import static java.awt.event.KeyEvent.*;

public class GameCanvas extends JPanel {


    BufferedImage backBuffer;
    Graphics backGraphics;
    ArrayList<Bullets> bullets = new ArrayList<>();
    Player player = new Player();
    ArrayList<Enemies> enemies = new ArrayList<>();
    BackGround backGround = new BackGround();
    ArrayList<EnemyBullets> eBullets = new ArrayList<>();
    GameWindow window;

    public GameCanvas(GameWindow window) {
        this.window = window;
        //1.Create a back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        enemies.add(new Enemies());
        //1.Load Background
    }

    public void render() {
        //1.Draw everything on back buffer

        backGround.render(backGraphics);


         player.render(backGraphics);

        for (Enemies enemy : enemies) {
           enemy.render(backGraphics);
        }

        for (Bullets bullets : bullets) {
            bullets.render(backGraphics);
        }
        for (EnemyBullets eBullets : eBullets){
            eBullets.render(backGraphics);
        }

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
        backGround.run();
        player.run();
        player.shoot(bullets);
        for (Enemies enemy : enemies) {

            enemy.run();
            enemy.shoot(eBullets);
        }
        for (Bullets bullet : bullets) {
            bullet.run();
        }
        for (EnemyBullets eBullet : eBullets){
            eBullet.run();
        }


        for (int i=0;i<bullets.size();i++){
            Bullets bullet = bullets.get(i);
            for(int j=0;j<enemies.size();j++){
                Enemies enemy = enemies.get(j);
                if( bullet.hitBox().intersects(enemy.hitBox())) {
                    bullets.remove(bullet);
                    enemies.remove(enemy);
                    i--;
                    break;
                }
            }

        }

        for (int i=0;i<eBullets.size();i++){
            EnemyBullets bullet = eBullets.get(i);
            if( bullet.hitBox().intersects(player.hitBox())) {
                eBullets.remove(bullet);
                window.endGame();
                break;
            }

        }

    }

}


