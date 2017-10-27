package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.player.Player;

import java.awt.*;

public class Enemies extends GameObject implements PhysicsBody{


    public BoxCollider boxCollider;
    public EnemiesShoot enemiesShoot;
    PlayerDamage playerDamage;

    public Enemies() {
        position.set(0, 0);
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        this.boxCollider = new BoxCollider(32, 48);
        playerDamage = new PlayerDamage();
        enemiesShoot = new EnemiesShoot();
    }

    public void run() {
        position.addUp(0, 2);
        boxCollider.position.set(this.position);
        playerDamage.run(this);
        enemiesShoot.run(this);

    }




    public void getHit() {
        isActive = false;

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
