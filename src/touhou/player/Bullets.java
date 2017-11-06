package touhou.player;

import bases.Animation;
import bases.GameObject;
import bases.ImageRender;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemies;
import touhou.enemies.Enemiestest;

import java.awt.image.BufferedImage;

public class Bullets extends GameObject implements PhysicsBody {

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public Bullets() {
        BufferedImage[] images = new BufferedImage[]{
                Utils.loadImage("assets/images/sphere/0.png"),
                Utils.loadImage("assets/images/sphere/1.png"),
                Utils.loadImage("assets/images/sphere/2.png"),
                Utils.loadImage("assets/images/sphere/3.png")
        };
        this.renderer = new Animation(images);
        boxCollider = new BoxCollider(16,16);
    }

    public void run() {
        position.y -= SPEED;
        boxCollider.position.set(this.position);
        Enemies enemy = GameObject.collideWith(this.boxCollider, Enemies.class);
        if (enemy != null){
            enemy.getHit();
            this.isActive = false;
        }

        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(position.y < 0){
            this.isActive = false;
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }


}
