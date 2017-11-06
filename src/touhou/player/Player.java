package touhou.player;

import bases.Animation;
import bases.GameObject;
import bases.ImageRender;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

public class Player extends GameObject implements PhysicsBody {



    public BoxCollider boxCollider;
    public PlayerCastSpell playerCastSpell;
    public MoveAndClamp moveAndClamp;

    public Player() {
        position.set(182, 500);
        this.boxCollider = new BoxCollider(32, 48);
        this.renderer = new Animation(
                Utils.loadImage("assets/images/players/straight/0.png"),
                Utils.loadImage("assets/images/players/straight/1.png"),
                Utils.loadImage("assets/images/players/straight/2.png"),
                Utils.loadImage("assets/images/players/straight/3.png"),
                Utils.loadImage("assets/images/players/straight/4.png"),
                Utils.loadImage("assets/images/players/straight/5.png"),
                Utils.loadImage("assets/images/players/straight/6.png")


        );

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
