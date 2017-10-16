package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_X;

public class Player {
    BufferedImage image;
    public int x = 182 ;
    public int y = 500;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed ;
    boolean already;

    final int SPEED =5;
    final int LEFT =0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int DOWN = 530;

    Enemies enemy = new Enemies();


    public Player(){
        image = Utils.loadImage("assets/images/players/straight/sua.png");
    }
    public void render(Graphics backGraphics){
        backGraphics.drawImage(image,x,y,null);
    }



  public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_RIGHT){

            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){

            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){

            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){

            downPressed = true;
        }
      if (e.getKeyCode() == VK_X){
          if (!already) xPressed = true;
      }

    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if ( e.getKeyCode() == VK_X){
            already = false;
        }
    }




    public void run(){
        int vx = 0;
        int vy = 0;



        if(rightPressed){

            vx += SPEED;
        }
        if(leftPressed){

            vx -= SPEED;
        }
        if(downPressed){

            vy += SPEED;
        }
        if(upPressed){

            vy -= SPEED;
        }
        x = x + vx;
        y = y + vy;

        x = (int) clamp(x,LEFT,RIGHT);
        y = (int) clamp(y,TOP,DOWN);



    }

    public void shoot(ArrayList<Bullets> bullets){
        if (xPressed) {
            already = true;
            xPressed = false;
            Bullets newBullet = new Bullets();
            newBullet.x = x;
            newBullet.y = y;

                bullets.add(newBullet);


        }

    }


    private float clamp(float value , float min , float max ){
        if (value < min ){
            return min;
        }
        if (value > max){
            return max;
        }
        return value;
    }

    public Rectangle hitBox (){
        return new Rectangle(x,y,32,48);
    }

}
