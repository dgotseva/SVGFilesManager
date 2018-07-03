
import java.util.*;


public class Circle implements Shape {
    
    private Point center;
    private int r;
    private String color;

    public Circle(){
        center = new Point(0,0);
    }

    @Override
    public void print(){
        System.out.println("circle " + center.toString() +" "+ r +" " + color);
    }

    @Override
    public Shape create(String input){
        Scanner sc = new Scanner(input);
        center.setX(sc.nextInt());
        center.setY(sc.nextInt());
        r = sc.nextInt();
        color = new String(sc.next());
        return this;
    }

    @Override
    public void erase(){}

    @Override
    public void translate(int horizontal,int vertical){
        center.setX(center.getX() + horizontal);
        center.setY(center.getY() + vertical);
        
    }
    @Override
    public String toString(){
   
        return String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />\r\n", center.getX(),center.getY(),r,color);
    }
}