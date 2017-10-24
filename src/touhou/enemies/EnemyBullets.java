package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.player.Bullets;
import touhou.player.Player;

import java.awt.*;

public class EnemyBullets extends GameObject {

    final int SPEED =10;
    public BoxCollider boxCollider;
    Bullets bullets;

    public EnemyBullets(){
        boxCollider = new BoxCollider(16,16);
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
    }

    public void run(){
    boxCollider.position.set(this.position);
        position.y += SPEED;
        Player player = GameObject.collideWithPlayer(this.boxCollider);
        if (player != null){
            player.getHit();
            this.isActive = false;

        }
    }
}
