package bases;

public class Vector2D {
    float x;
    float y;


    public Vector2D(float x, float y) {
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

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
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


    public void subtractBy(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
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

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }


}
