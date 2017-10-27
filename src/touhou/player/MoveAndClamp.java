package touhou.player;

import bases.Vector2D;
import touhou.inputs.InputManager;

public class MoveAndClamp {
    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 370;
    final int TOP = 0;
    final int DOWN = 550;

    public Vector2D velorcity = new Vector2D(0, 0);

    public void run(Vector2D position, int LEFT, int RIGHT) {
        velorcity.set(0, 0);

        InputManager inputManager = InputManager.instance;
        if (inputManager.rightPressed) {
            velorcity.x += SPEED;
        }
        if (inputManager.leftPressed) {

            velorcity.x -= SPEED;
        }
        if (inputManager.downPressed) {

            velorcity.y += SPEED;
        }
        if (inputManager.upPressed) {

            velorcity.y -= SPEED;
        }
        position.addUp(velorcity);

        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, DOWN);

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
