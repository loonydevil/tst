package rubicon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rubicon.parse.Reader;
import rubicon.parse.ReaderFactory;

public class App {
    
    /**
     * Program's entry point, takes two arguments as input:
     * 1 - path to directory with input files
     * 2 - path to file where to store results
     */
    public static void main(String[] args) {
        checkInputData(args);
        ReaderFactory factory = new ReaderFactory();
        File output = new File(args[1]);
        
        try (FileWriter writer = new FileWriter(output, false)) {
            for (File file : new File(args[0]).listFiles()) {
                Reader reader = factory.getReader(file);
                if (reader == null) {
                    System.out.println("File type is not supported: " + file);
                    continue;
                }
                ObjectMapper mapper = new ObjectMapper();
                writer.append(mapper.writeValueAsString(reader.getSites()) + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Done");
    }
    
    /**
     * Basic validation of input data
     * @param data - input arguments supplied via command line
     */
    private static void checkInputData(String[] data) {
        if (data.length != 2) {
            exit("Wrong number of arguments.\nUsage:\n\tjava -jar devtest-*.*.jar input-path output-path");
        }
        File file = new File(data[0]);
        if (!(file.exists() && file.isDirectory() && file.list().length != 0)) {
            exit("First argument should be a non-empty directory. Exiting.");
        }
    }
    
    private static void exit(String msg) {
        System.out.println(msg);
        System.exit(1);
    }
}
