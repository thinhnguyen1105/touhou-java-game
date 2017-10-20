package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject {

    public BackGround (){
        x = 0;
        y = 0;
        image = Utils.loadImage("assets/images/background/0.png");
    }

    public void run (){
        y += 5;
        if (y == -300){
            y = -4500;
        }
    }
}
