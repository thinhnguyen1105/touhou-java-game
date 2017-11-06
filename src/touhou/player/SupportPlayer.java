package touhou.player;

import bases.*;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.inputs.InputManager;

import java.awt.image.BufferedImage;

public class SupportPlayer extends GameObject implements PhysicsBody {

    public BoxCollider boxCollider;
    Player player ;
    MoveAndClamp moveAndClamp;
    final int RADIUS = 50;
    PlayerCastSpell playerCastSpell;

    public SupportPlayer(){
        player = new Player();
        moveAndClamp = new MoveAndClamp();
        playerCastSpell = new PlayerCastSpell();


        position.set(player.position.x+RADIUS , player.position.y);
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new Animation(
                Utils.loadImage("assets/images/sphere/0.png"),
                Utils.loadImage("assets/images/sphere/1.png"),
                Utils.loadImage("assets/images/sphere/2.png"),
                Utils.loadImage("assets/images/sphere/3.png")

        );

    }

    public void run (){

        moveAndClamp.run(this.position,100,370);
        boxCollider.position.set(this.position);
        playerCastSpell.run(this);


    }




    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
