package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullets {

    BufferedImage image;
    public int x ;
    public int y ;

    final int SPEED =10;

    public EnemyBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
    }
    public void render(Graphics backGraphics){
        backGraphics.drawImage(image,x,y,null);
    }

    public void run(){

        y += SPEED;
    }
    public Rectangle hitBox (){
        return new Rectangle(x,y,16,16);
    }

}
