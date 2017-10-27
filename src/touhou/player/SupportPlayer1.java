package touhou.player;

import bases.physics.BoxCollider;

public class SupportPlayer1 extends SupportPlayer{
    public SupportPlayer1() {

        position.set(player.position.x-RADIUS , player.position.y);
    }

    @Override
    public void run() {

        moveAndClamp.run(this.position,0,270);
        playerCastSpell.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
