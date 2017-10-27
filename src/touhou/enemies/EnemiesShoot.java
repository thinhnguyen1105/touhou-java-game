package touhou.enemies;

import bases.GameObject;
import static bases.GameObject.recycle;

public class EnemiesShoot {
    long lastTimeUpade;

    public EnemiesShoot(){
        lastTimeUpade = System.nanoTime();
    }


    public void run(Enemies owner) {
        long currentTime = System.nanoTime();
        if (currentTime - lastTimeUpade >= 900000000) {
            recycle(EnemyBullets.class).position.set(owner.position.x,owner.position.y +owner.image.getHeight()/2);
            lastTimeUpade = currentTime;
        }
    }
}
