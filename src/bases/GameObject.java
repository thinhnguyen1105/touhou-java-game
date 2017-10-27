package bases;

import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemies;
import touhou.player.Bullets;
import touhou.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {

    public Vector2D position ;
    public BufferedImage image;
    public boolean isActive;
    Player player;
    Enemies enemy;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if(gameObject.isActive){
                gameObject.run();
            }

        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            if(gameObject.isActive){
                gameObject.render(g);
            }
        }
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }


    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider , Class <T> cls){
       for (GameObject gameObject : gameObjects){
         if (!gameObject.isActive) continue;
         if(!(gameObject instanceof PhysicsBody)) continue;
         if(!(gameObject.getClass().equals(cls))) continue;
         BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
         if(otherBoxCollider.collideWidth(boxCollider)){
             return (T)gameObject;
         }
       }
       return  null;
    }

    public static <T extends  GameObject> T recycle(Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getClass().equals(cls)) {
                if (!gameObject.isActive) {
                    (gameObject).isActive = true;
                    return (T) gameObject;
                }
            }

        }
        try {
            T newGameObject = cls.newInstance();
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;

        }
    }


    public static void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image,
                    (int) (position.x - (image.getWidth()/2)),
                    (int) (position.y - (image.getHeight()/2)),
                    null);
        }
    }


    public void run() {
    }

    public void getHit(){
        isActive = false;
    }




}


