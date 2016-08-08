package rubicon.parse;

import java.io.File;

import rubiconproject.KeywordService;
import rubiconproject.KeywordServiceMockImpl;

public class ReaderFactory {

    public static final String JSON_FORMAT = "json";
    public static final String CSV_FORMAT = "csv";
    
    private final KeywordService keywordService = new KeywordServiceMockImpl();

    public Reader getReader(File file) {
        
        if (!file.isFile()) {
            System.out.println("Skipping as entry is not a file: " + file.getAbsolutePath());
        }

        String extension = file.getName().substring(file.getName().lastIndexOf('.') + 1);

        switch (extension) {
        case JSON_FORMAT:
            return new JsonReader(file, keywordService);
        case CSV_FORMAT:
            return new CsvReader(file, keywordService);
        default:
            return null;
        }
    }
}
