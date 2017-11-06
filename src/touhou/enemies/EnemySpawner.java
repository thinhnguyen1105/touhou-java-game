package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(120);
    Random random = new Random();

    @Override
    public void run() {
        if(frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }

    private void spawn() {
//        Enemiestest enemy = new Enemiestest();
//        enemy.position.y = 10;
//        enemy.position.x = random.nextInt(360);
//        GameObject.add(enemy);
        Enemies boss = new Enemies();
        boss.position.x = random.nextInt(360);
        boss.position.y = -75;
        boss.boxCollider.position.set(boss.position);
        GameObject.add(boss);
    }
}
