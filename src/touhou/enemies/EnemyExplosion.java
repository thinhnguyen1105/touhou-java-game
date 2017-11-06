package touhou.enemies;

import bases.Animation;
import bases.GameObject;
import bases.Utils;

public class EnemyExplosion extends GameObject{

    @Override
    public void run() {
        super.run();
        Animation animation = (Animation)this.renderer;
        if(animation.ended){
            this.isActive = false;
        }
    }

    public EnemyExplosion(){
        this.renderer = new Animation(
                false,
                Utils.loadImage("assets/images/enemies/explosion/0.png"),
                Utils.loadImage("assets/images/enemies/explosion/1.png"),
                Utils.loadImage("assets/images/enemies/explosion/2.png"),
                Utils.loadImage("assets/images/enemies/explosion/3.png"),
                Utils.loadImage("assets/images/enemies/explosion/4.png"),
                Utils.loadImage("assets/images/enemies/explosion/5.png"),
                Utils.loadImage("assets/images/enemies/explosion/6.png"),
                Utils.loadImage("assets/images/enemies/explosion/7.png")
                );


    }

    @Override
    public void reset() {
        super.reset();
        Animation animation = (Animation)this.renderer;
        animation.ended = false;
        animation.currentImageIndex = 0;

    }
}
