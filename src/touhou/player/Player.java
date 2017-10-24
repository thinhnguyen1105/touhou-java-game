package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.enemies.Enemies;

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
    final int RIGHT = 370;
    final int TOP = 0;
    final int DOWN = 550;
    public BoxCollider boxCollider;

    public Player() {
       position.set(182,500);
        this.boxCollider = new BoxCollider(32, 48);
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
        boxCollider.position.set(this.position);
        move();
        shoot();
        Enemies enemy = GameObject.collideWith(this.boxCollider);
        if (enemy != null){
            enemy.getHit();
        }
    }

    public Vector2D velorcity = new Vector2D(0,0);

    private void move() {
        velorcity.set(0,0);
        if (rightPressed) {
            velorcity.x += SPEED;
        }
        if (leftPressed) {

            velorcity.x -= SPEED;
        }
        if (downPressed) {

            velorcity.y += SPEED;
        }
        if (upPressed) {

            velorcity.y -= SPEED;
        }
        position.addUp(velorcity);

        position.x = (int) clamp(position.x,LEFT,RIGHT);
        position.y = (int) clamp(position.y, TOP, DOWN);

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
            newBullet.position.set(position.x, position.y - (image.getHeight()/2));
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



}
