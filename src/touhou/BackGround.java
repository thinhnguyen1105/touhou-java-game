package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround {
    BufferedImage image;
    public  int x = 0;
    public int y = -4500;
    public BackGround (){
        image = Utils.loadImage("assets/images/background/1.png");
    }

    public void render (Graphics backGraphic){
       backGraphic.drawImage(image,x,y,null);
    }

    public void run (){
        y += 5;
        if (y == -300){
            y = -4500;
        }
    }
}
