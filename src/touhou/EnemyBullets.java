package touhou;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullets extends GameObject {

    final int SPEED =10;

    public EnemyBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
    }

    public void run(){

        y += SPEED;
    }
    public Rectangle hitBox (){
        return new Rectangle((int)x,(int)y,16,16);
    }

}
