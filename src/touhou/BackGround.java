package touhou;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject {

    @Override
    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image,
                    (int) (position.x ),
                    (int) (position.y - 4500 ),
                    null);
        }
    }

    public BackGround (){
        image = Utils.loadImage("assets/images/background/1.png");
    }

    public void run (){
        position.y += 5;
        if (position.y == 4500){
            position.y = 300;
        }
    }
}
