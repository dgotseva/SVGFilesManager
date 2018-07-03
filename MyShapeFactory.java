
public class MyShapeFactory{
   
   public static Shape createShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.startsWith("circle")){
         return new Circle();
         
      } else if(shapeType.startsWith("rect")){
         return new Rectangle();
         
      } 
      return null;
   }


}