package touhou.player;

import bases.physics.BoxCollider;

public class SupportPlayer1 extends SupportPlayer{
    public BoxCollider boxCollider;

    public SupportPlayer1() {
        this.boxCollider = new BoxCollider(16,16);
        position.set(player.position.x-RADIUS , player.position.y);
    }

    @Override
    public void run() {

        moveAndClamp.run(this.position,0,270);
        playerCastSpell.run(this);
        boxCollider.position.set(this.position);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
