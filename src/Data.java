import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {

    private static String directory = "data";
    private static String filename = "contacts.txt";
    private static Path dataDirectory = Paths.get(directory);
    private static Path dataFilename = Paths.get(directory,filename);

    public static void allData(){

        try{


        if(Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
            if(Files.notExists(dataFilename)) {
                Files.createFile(dataFilename);
            }
    }
        catch (IOException e) {
            allData();
        }







}}
