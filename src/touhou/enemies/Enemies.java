package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;

import java.awt.*;

public class Enemies extends GameObject {
    long lasTimeUpade;

    public BoxCollider boxCollider;

    public Enemies() {
        position.set(0, 0);
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        this.boxCollider = new BoxCollider(32, 48);
        lasTimeUpade = System.nanoTime();
    }

    public void run() {
        position.addUp(0, 2);
        boxCollider.position.set(this.position);

        shoot();
    }

    public void shoot() {
        long currentTime = System.nanoTime();
        if (currentTime - lasTimeUpade >= 900000000) {
            EnemyBullets newBullet = new EnemyBullets();
            newBullet.position.x = (int) position.x;
            newBullet.position.y = (int) position.y + image.getHeight()/2;
            GameObject.add(newBullet);
            lasTimeUpade = currentTime;
        }


    }


    public void getHit() {
        isActive = false;

    }
}
