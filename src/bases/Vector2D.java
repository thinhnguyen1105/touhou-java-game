package bases;

import java.util.Vector;

public class Vector2D {
    public float x;
    public float y;


    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }


    public void print() {
        System.out.println(x + "," + y);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D a){
        this.set(a.x,a.y);
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D v) {
        this.addUp(v.x, v.y);
    }

    public Vector2D add(float x, float y) {
        float a = this.x + x;
        float b = this.y + y;
        return new Vector2D(a, b);
    }

    public Vector2D add(Vector2D v) {
        float a = this.x + v.x;
        float b = this.y + v.y;
        return new Vector2D(a, b);
    }


    public void subtractBy(float x, float y ) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D other){
        subtractBy(other.x,other.y);
    }

    public Vector2D subtract(Vector2D v) {
        float a = this.x - v.x;
        float b = this.y - v.y;
        return new Vector2D(a, b);
    }

    public void multiply(Vector2D v) {
        this.x *= v.x;
        this.y *= v.y;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize(){
        float length = length();
        return new Vector2D(this.x/length,this.y/length);
    }
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
