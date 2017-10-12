import sun.awt.image.PixelConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background,player, enemy;
    int playerX = 182 ;
    int playerY = 500;
    int backGroundX = 0;
    int backGroundY = -4500;
    int enemyX = 182;
    int enemyY =50;



    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    BufferedImage backBuffer;
    Graphics backGraphics;

    public GameCanvas(){
        //1.Create a back buffer
        backBuffer = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //1.Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/1.png"));
            player =ImageIO.read(new File("assets/images/players/straight/0.png"));
            enemy = ImageIO.read(new File("assets/images/enemies/level0/black/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render () {
        //1.Draw everything on back buffer
        backGraphics.drawImage(background,backGroundX,backGroundY,null);
        backGraphics.drawImage(player,playerX,playerY,null);
        backGraphics.drawImage(enemy,enemyX,enemyY,null);
        //2. Call repaint
        repaint();
    }
    //2. Draw background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);

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
    }

    public void run(){
        int vx = 0;
        int vy = 0;

        enemyY++;
        if ( enemyY >= 525){
           enemyY--;
        }

        if(rightPressed){
            vx += 5;
        }
        if(leftPressed){
            vx -= 5;
        }
        if(downPressed){
            vy += 5;
        }
        if(upPressed){
            vy -=5;
        }
        if (playerX <= 0 ){
            playerX +=1;
        }else if (playerX >= 348 ){
            playerX --;
        }
        else if (playerY <= 0){
            playerY ++;
        }else if (playerY >= 525){
            playerY --;
        }
            else{
                playerX = playerX + vx;
                playerY = playerY + vy;

            }





        backGroundY +=10;
        if (backGroundY == -300){
            backGroundY = -4500;
        }
    }
}
