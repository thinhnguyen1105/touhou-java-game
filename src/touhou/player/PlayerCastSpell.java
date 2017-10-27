package touhou.player;

import bases.GameObject;
import bases.Vector2D;
import touhou.inputs.InputManager;

import java.awt.image.BufferedImage;

import static bases.GameObject.recycle;

public class PlayerCastSpell  {
    boolean spellDisable;
    final int COOL_DOWN_TIME = 10;
    int coolDownTime;

    public void run (GameObject owner ){
        if (spellDisable) {
            coolDownTime++;
            if (coolDownTime >= COOL_DOWN_TIME) {
                spellDisable = false;
                coolDownTime = 0;
            }
            return;
        }
        if (InputManager.instance.xPressed) {
            recycle(Bullets.class).position.set(owner.position.x, owner.position.y - (owner.image.getHeight()/2));
            spellDisable = true;

        }
        }
    }

