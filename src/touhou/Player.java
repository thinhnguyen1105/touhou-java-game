package touhou;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;


    boolean spellDisable;
    final int COOL_DOWN_TIME = 10;
    int coolDownTime;


    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int DOWN = 530;


    public Player() {
        x = 182;
        y = 500;
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            downPressed = true;
        }
        if (e.getKeyCode() == VK_X) {
            xPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == VK_X) {
            xPressed = false;
        }
    }


    public void run() {
        move();
        shoot();

    }

    private void move() {
        int vx = 0;
        int vy = 0;


        if (rightPressed) {

            vx += SPEED;
        }
        if (leftPressed) {

            vx -= SPEED;
        }
        if (downPressed) {

            vy += SPEED;
        }
        if (upPressed) {

            vy -= SPEED;
        }
        x = x + vx;
        y = y + vy;

        x = (int) clamp(x, LEFT, RIGHT);
        y = (int) clamp(y, TOP, DOWN);


    }


    public void shoot() {
        if (spellDisable) {
            coolDownTime++;
            if (coolDownTime >= COOL_DOWN_TIME) {
                spellDisable = false;
                coolDownTime = 0;
            }
            return;
        }
        if (xPressed) {
            Bullets newBullet = new Bullets();
            newBullet.x = x;
            newBullet.y = y;
            GameObject.add(newBullet);
            spellDisable = true;
        }
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

    public Rectangle hitBox() {
        return new Rectangle((int) x, (int) y, 32, 48);
    }

}
