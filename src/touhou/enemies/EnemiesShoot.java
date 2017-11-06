package touhou.enemies;

import static bases.GameObject.recycle;

public class EnemiesShoot {
    long lastTimeUpade;

    public EnemiesShoot(){
        lastTimeUpade = System.nanoTime();
    }


    public void run(Enemiestest owner) {
        long currentTime = System.nanoTime();
        if (currentTime - lastTimeUpade >= 900000000) {
            recycle(EnemyBullets.class).position.set(owner.position.x,owner.position.y +25);
            lastTimeUpade = currentTime;
        }
    }
}
