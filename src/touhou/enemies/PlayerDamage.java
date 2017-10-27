package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.player.Player;

public class PlayerDamage {
    public void run (Enemies owner){
        BoxCollider boxCollider =  owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if (player != null){
            player.getHit();
            System.exit(0);
        }
    }
}
