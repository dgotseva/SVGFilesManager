
public class Point{
    private int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int val){
        x = val;
    }

    public void setY(int val){
        y = val;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return new String("" + x + " " + y ); 
    }


}