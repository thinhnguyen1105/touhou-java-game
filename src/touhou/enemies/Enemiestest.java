package touhou.enemies;

import bases.GameObject;
import bases.ImageRender;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.player.Player;

import java.awt.*;

public class Enemiestest extends GameObject implements PhysicsBody{


    public BoxCollider boxCollider;
    public EnemiesShoot enemiesShoot;
    PlayerDamage playerDamage;

    public Enemiestest() {
        position.set(0, 0);
        this.renderer = new ImageRender("assets/images/enemies/level0/black/0.png");
        this.boxCollider = new BoxCollider(32, 48);
        playerDamage = new PlayerDamage();
        enemiesShoot = new EnemiesShoot();
    }

    public void run() {
//        position.addUp(0, 2);
//        boxCollider.position.set(this.position);
////        playerDamage.run(this);
//        enemiesShoot.run(this);

    }




    public void getHit() {
        isActive = false;

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
