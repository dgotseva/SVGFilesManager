
import java.util.*;

public class LoadedShapes{

    private static LoadedShapes instance = new LoadedShapes();
    private List<Shape> shapes = new ArrayList<Shape>();

    private LoadedShapes(){};

    public static LoadedShapes getInstance(){
        return instance;
    }

    public void create(String s){   
        if( buildShape(s) == true){
             System.out.println("Successfully created " + s.substring(0,s.indexOf(' ')) + " (" + shapes.size() + ")");
        }
    }

    public void print(){
        for(Shape i : shapes){
            System.out.printf("(%d) ", shapes.indexOf(i)+1);
            i.print();
        }
    }

    public void erase(String s){
        int index = (new Scanner(s)).nextInt();
        if(index <= shapes.size()){
            shapes.remove(index-1);
            System.out.printf("Successfully removed %d\n",index);
        }
        else
            System.out.println("There is no shape number " + index);

    }

    public void translate(String s){   
        Scanner sc = new Scanner(s.replaceAll( "(\\D*)(\\d+)", "$2 "));
        int horizontal = sc.nextInt();
        int vertical = sc.nextInt();
       
        if(sc.hasNextInt()){
            int index = sc.nextInt();
            if(index > shapes.size()){
                System.out.println("There is no shape number " + index);
            }else {
                shapes.get(index-1).translate(horizontal,vertical);
                System.out.printf("Successfully translated %d \n",index);
            }
        }else {
            
            for(Shape sh: shapes){
                sh.translate(horizontal,vertical);
            }
            System.out.println("Translated all shapes");
        }
    }

    private boolean buildShape(String s){

        Shape sh = MyShapeFactory.createShape(s);
        if(sh != null){
             sh.create(s.substring(s.indexOf(' ')));

             shapes.add(sh);
             return true;
        }
        return false;

    }

    public void  load(String[] s){
        for(String str : s)
            buildShape(str);
    }

    public String saveAll(){
        String res = "\n";
        for(Shape sh : shapes){
            res += "\t" + sh.toString() ;
        }
        return res;

    }

    public void reset(){
        shapes.clear();
    }



}