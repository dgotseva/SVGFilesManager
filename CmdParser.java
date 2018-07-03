import java.util.*;
import java.nio.file.*;

interface Command{
   public void exec(String parameters);
}

public class CmdParser{

    private LoadedShapes shapes;
    private LoadedFile file;
    private Map<String,Command> commands;

    public CmdParser(){
        shapes = LoadedShapes.getInstance();
        commands = new HashMap<String,Command>();
        file = new LoadedFile();
       
        commands.put("open", fileName -> { if(file.open(fileName)==true){
                                            System.out.println("Successfully opened " + fileName);
                                            shapes.load(file.getShapes()); }});
        commands.put("save", str -> file.save(shapes.saveAll()));
        commands.put("saveas", newFileName -> file.saveas(newFileName,shapes.saveAll()));      
        commands.put("close", str -> {  file.close();
                                        shapes.reset(); });

        commands.put("create", parameters -> shapes.create(parameters));
        commands.put("print", str -> shapes.print());
        commands.put("erase", parameters -> shapes.erase(parameters));
        commands.put("translate", parameters -> shapes.translate(parameters));

    }

    public void loop(){
        Scanner sc = new Scanner(System.in);
        String command = new String();
        String parameters = new String();

        while(true){
            System.out.print("> ");
            command = sc.next();
            parameters = sc.nextLine();

            if(commands.containsKey(command))
                commands.get(command).exec(parameters.trim());

            else if(command.compareToIgnoreCase("exit") == 0){
                System.out.println("Exit!");
                break;
            }

        }


    }




}