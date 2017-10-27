package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemies;

import java.awt.*;

public class Bullets extends GameObject implements PhysicsBody {

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public Bullets() {
        image = Utils.loadImage("assets/images/enemies/bullets/red.png");
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
