package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.player.Bullets;
import touhou.player.Player;
import touhou.player.SupportPlayer;
import touhou.player.SupportPlayer1;

import java.awt.*;

public class EnemyBullets extends GameObject {

    final int SPEED = 10;
    public BoxCollider boxCollider;
    Bullets bullets;


    public EnemyBullets() {
        boxCollider = new BoxCollider(16, 16);
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");

    }

    public void run() {
        position.y += SPEED;
        boxCollider.position.set(this.position);
        SupportPlayer sp = GameObject.collideWith(boxCollider, SupportPlayer.class);
        if( sp!= null){
            sp.getHit();

            this.isActive = false;
        }
        SupportPlayer1 sp1 = GameObject.collideWith(boxCollider, SupportPlayer1.class);
        if( sp1 != null){
            sp1.getHit();
            this.isActive = false;
        }

        Player player = GameObject.collideWith(boxCollider, Player.class);
        if( player != null){
            player.getHit();
            this.isActive = false;
            System.exit(0);
        }



        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (position.y > 800) {
            this.isActive = false;
        }
    }
}
