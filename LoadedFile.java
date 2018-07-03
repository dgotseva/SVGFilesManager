import java.nio.file.*;
import java.io.*;

public class LoadedFile{
    
    private String fileName;
    private String fileContent;
    private boolean isOpen; 

    public LoadedFile(){
        isOpen = false;

    }

    public boolean open(String name){

        if(isOpen == true){
            System.out.println("First close " + fileName);
            return false;
        }

        fileName = new String(name);
        
        try { 
            fileContent = new String(Files.readAllBytes(Paths.get(fileName))); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    
        isOpen = true;
        return true;

    }

    public void save(String changes){
        if(writeToFile(getText(changes),fileName) == true){
            System.out.println("Saved ");
        } else {
            System.out.println("Saving changes failed! ");
        }

    }

    public void saveas(String newFileName,String changes){
         if(writeToFile(getText(changes),newFileName) == true){
            System.out.println("Saved to " + newFileName);
         }
    }

    public void close(){
        isOpen = false;
        fileName = null;
        fileContent = null;
    }

   

    public String[] getShapes(){

        if (fileContent == null)
            return null;
          
        int start = fileContent.indexOf(">",fileContent.indexOf("<svg")+1)+1;
        int end = fileContent.indexOf("</svg",start);

        String tmp = fileContent.substring(start,end).replaceAll("(<)(.*)(/>)","$2");
        String[] res = tmp.split("\n"); 
        for(int i = 0; i < res.length; i++){
            res[i] = res[i].replaceAll("( \\w+=\")(\\w+)(\")"," $2").trim();
        }

        return res;

    }

    private static boolean writeToFile(String data,String file){
        try {
            Files.write(Paths.get(file), data.getBytes());
        } catch (IOException e) {  
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String getText(String changes){
        int start = fileContent.indexOf(">",fileContent.indexOf("<svg")+1) + 1;
        int end = fileContent.indexOf("</svg",start);
        String res = fileContent.substring(0,start).concat(changes).concat(fileContent.substring(end));
        System.out.println(res);
        return res;
    }


}