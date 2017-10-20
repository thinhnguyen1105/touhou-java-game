import bases.NewRectangle;
import bases.Vector2D;
import com.sun.javafx.event.EventHandlerManager;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import touhou.A;
import touhou.Base;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
//        GameWindow gameWindow = new GameWindow();
//        gameWindow.GameLoop();

//        Vector2D<Integer> numbers = new Vector2D<>();
//        numbers.add(1);
//        numbers.add(10);
//        for (Integer number : numbers){
//            System.out.println(number);
//        }
//        Vector2D v1 = new Vector2D(1,5);
//        Vector2D v2 = new Vector2D( 1,1);
//
//        v1.print();
//
//        v1.set(2,5);
//
//        v1.addUp(1,1);
//        v1.addUp(v2);
        NewRectangle r1= new NewRectangle(3,3,4,4);
        NewRectangle r2= new NewRectangle(6,6,6,6);
        NewRectangle.check(r1,r2);


    }
}