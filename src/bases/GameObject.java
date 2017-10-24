package bases;

import bases.physics.BoxCollider;
import touhou.enemies.Enemies;
import touhou.player.Bullets;
import touhou.player.Player;

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

    public static Enemies collideWith(BoxCollider boxCollider){
        for (GameObject gameObject :gameObjects){
            if (gameObject instanceof  Enemies){
                Enemies enemy = (Enemies)gameObject;
                if (enemy.boxCollider.collideWidth(boxCollider)){
                    return enemy;
                }
            }
    }
            return null;
    }

    public static Player collideWithPlayer(BoxCollider boxCollider){
        for (GameObject gameObject :gameObjects){
            if (gameObject instanceof  Player){
                Player player = (Player) gameObject;
                if (player.boxCollider.collideWidth(boxCollider)){
                    return player;
                }
            }
        }
        return null;
    }

    public static Bullets collideWithBullet(BoxCollider boxCollider){
        for (GameObject gameObject :gameObjects){
            if (gameObject instanceof  Bullets){
                Bullets bullets = (Bullets) gameObject;
                if (bullets.boxCollider.collideWidth(boxCollider)){
                    return bullets;
                }
            }
        }
        return null;
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
