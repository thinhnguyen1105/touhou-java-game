package bases;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRender implements Renderer {
    public BufferedImage image;

    public ImageRender(BufferedImage image){
        this.image =image;
    }

    public ImageRender(String url){
        this.image = Utils.loadImage(url);
    }

    public void render(Graphics g, Vector2D position) {
        if (image != null) {
            g.drawImage(image,
                    (int) (position.x - (image.getWidth()/2)),
                    (int) (position.y - (image.getHeight()/2)),
                    null);
        }
    }

}
