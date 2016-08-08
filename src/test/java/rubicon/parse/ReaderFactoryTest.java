package rubicon.parse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReaderFactoryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ReaderFactory readerFactory = new ReaderFactory();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
    @Test
    public void skipsNonFiles() {
        File file = new File("non-existing-path");
        Reader reader = readerFactory.getReader(file);
        assertNull("Reader should be null for non-existing file", reader);
        assertTrue(outContent.toString().contains("Skipping"));
    }
    
    @Test
    public void returnsCsvReaderForCsvFormat() {
        File file = new File("/somewhere/in/system/file.csv");
        Reader reader = readerFactory.getReader(file);
        assertTrue(reader instanceof CsvReader);
    }

    @Test
    public void returnsJsonReaderForJsonFormat() {
        File file = new File("/somewhere/in/system/file.json");
        Reader reader = readerFactory.getReader(file);
        assertTrue(reader instanceof JsonReader);
    }

}
