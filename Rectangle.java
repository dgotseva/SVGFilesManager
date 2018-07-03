import java.util.*;

public class Rectangle implements Shape{
    
    Point vertex;
    int width;
    int height;
    String color;

    public Rectangle(){
        vertex = new Point(0,0);
    }

    @Override
    public Shape create(String input){

        Scanner sc = new Scanner(input);
        vertex.setX(sc.nextInt());
        vertex.setY(sc.nextInt());
        width = sc.nextInt();
        height = sc.nextInt();
        color = new String(sc.next());

        return this;
    }

    @Override
    public void print(){
        System.out.println("rect " + vertex.toString() + " " + width + " " + height + " " + color);
    }

    @Override
    public void erase(){}

    @Override
    public void translate(int horizontal, int vertical){
        vertex.setX(vertex.getX() + horizontal);
        vertex.setY(vertex.getY() + vertical);
    }

    @Override
    public String toString(){
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />\r\n",
                        vertex.getX(),vertex.getY(),width,height,color);
    }

}