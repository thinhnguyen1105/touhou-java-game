package touhou;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;

import java.awt.*;

public class Enemies extends GameObject {
    long lasTimeUpade;


    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int DOWN = 530;


    public Enemies() {
        x = 182;
        y = 50;
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        lasTimeUpade = System.nanoTime();
    }

    public void run() {
        double a = Math.random();
        if (a < 0.2) {
            x += 10;
        } else if (a >= 0.2 && a < 0.4) {
            x -= 10;
        } else if (a >= 0.4 && a < 0.6) {
            y -= 10;
        } else if (a >= 0.6 && a < 0.8) {
            y += 10;
        }

        x = (int) clamp(x, LEFT, RIGHT);
        y = (int) clamp(y, TOP, DOWN);


        shoot();
    }

    public void shoot() {
        long currentTime = System.nanoTime();
        if (currentTime - lasTimeUpade >= 200000000) {
            EnemyBullets newBullet = new EnemyBullets();
            newBullet.x = (int) x;
            newBullet.y = (int) y;
            GameObject.add(newBullet);
            lasTimeUpade = currentTime;
        }


    }

    public Rectangle hitBox() {
        return new Rectangle((int) x, (int) y, 34, 50);
    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
}
