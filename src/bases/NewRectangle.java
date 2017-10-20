package bases;


import java.awt.*;

public class NewRectangle  {
    public int x;
    public int y;
    public int width;
    public int height;


    public NewRectangle(int x, int y,int width,int height){
        this.x =x;
        this.y =y;
        this.width = width;
        this.height = height;
    }

    public Rectangle hitBox(){
        return new Rectangle(x,y,width,height);
    }

    public static void check(NewRectangle a, NewRectangle b){
        if (a.hitBox().intersects(b.hitBox())){
            System.out.println("overlap");
        }
        else{
            System.out.println("not overlap");
        }
    }
}
