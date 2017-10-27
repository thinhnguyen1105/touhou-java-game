package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemies;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

public class Player extends GameObject implements PhysicsBody {



    public BoxCollider boxCollider;
    public PlayerCastSpell playerCastSpell;
    public MoveAndClamp moveAndClamp;

    public Player() {
        position.set(182, 500);
        this.boxCollider = new BoxCollider(32, 48);
        image = Utils.loadImage("assets/images/players/straight/sua.png");

        playerCastSpell = new PlayerCastSpell();
        moveAndClamp = new MoveAndClamp();
    }


    public void run() {
        boxCollider.position.set(this.position);
        playerCastSpell.run(this);
        moveAndClamp.run(this.position,50,320);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
