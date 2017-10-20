package bases;

import touhou.Enemies;
import touhou.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public float x;
    public float y;
    public BufferedImage image;
    Player player;
    Enemies enemy;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            gameObject.run();

        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(g);
        }
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public static void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public GameObject() {

    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int) x, (int) y, null);
        }
    }

    public void run() {


    }




}
