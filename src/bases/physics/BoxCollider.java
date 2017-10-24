package bases.physics;

import bases.Vector2D;

import javax.swing.*;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width,float height){
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left(){
        return position.x - width/2;
    }

    public float right(){
        return position.x + width/2;
    }

    public float up(){
        return position.y - height/2;
    }

    public float down(){
        return  position.y + height/2;
    }

    public boolean collideWidth(BoxCollider other){
        boolean xCheck = ( this.right() >= other.left() && this.left() <= other.right());
        boolean yCheck = (this.down()>= other.up() && this.up() <= other.down());
        return xCheck && yCheck;
    }
}
