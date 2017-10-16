package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Enemies {
    BufferedImage image;
    public int x = 182 ;
    public int y = 50;
    long lasTimeUpade;

    final int SPEED =5;

    public Enemies() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        lasTimeUpade = System.nanoTime();
    }

    public void render (Graphics backGraphics) {
        backGraphics.drawImage(image,x,y,null);

    }

    public void run(){

            y ++;



    }

    public void shoot(ArrayList<EnemyBullets> bullets){
        long currentTime = System.nanoTime();
        if ( currentTime - lasTimeUpade >= 900000000){
            System.out.println("yes");
            EnemyBullets newBullet = new EnemyBullets();
            newBullet.x = x;
            newBullet.y = y;
            bullets.add(newBullet);
            lasTimeUpade =  currentTime;
        }


    }

    public Rectangle hitBox (){
        return new Rectangle(x,y,34,50);
    }
}
