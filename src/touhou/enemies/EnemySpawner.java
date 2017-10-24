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
        Enemies enemy = new Enemies();
        enemy.position.y = 10;
        enemy.position.x = random.nextInt(360);
        GameObject.add(enemy);
    }
}
