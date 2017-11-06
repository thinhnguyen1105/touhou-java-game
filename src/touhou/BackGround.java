package touhou;

import bases.GameObject;
import bases.ImageRender;
import bases.Utils;
import bases.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject {

    public BackGround (){
        ImageRender imageRender =  new ImageRender("assets/images/background/1.png");
        this.renderer = imageRender;
        this.position.x = imageRender.image.getWidth() / 2;
        this.position.y = -1900;
    }

    public void run (){
        position.y += 5;
        if (position.y == 2420){
            position.y = -1900;
        }
    }
}
