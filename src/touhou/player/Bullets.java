package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.enemies.Enemies;

import java.awt.*;

public class Bullets extends GameObject {

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public Bullets() {
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
        boxCollider = new BoxCollider(16,16);
    }

    public void run() {
        position.y -= SPEED;
        boxCollider.position.set(this.position);
        Enemies enemy = GameObject.collideWith(this.boxCollider);
        if (enemy != null){
            enemy.getHit();
            this.isActive = false;
        }
    }
}
