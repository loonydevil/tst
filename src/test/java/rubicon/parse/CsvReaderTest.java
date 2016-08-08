package rubicon.parse;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import rubicon.model.Site;
import rubicon.model.SiteHolder;
import rubiconproject.KeywordServiceMockImpl;

public class CsvReaderTest extends ReaderTestBase {
    
    protected static final String PATH = "src/test/resources/input/";
    private static final String FILENAME = "input1.csv";
    protected Reader csvReader = new CsvReader(new File(PATH + FILENAME), new KeywordServiceMockImpl());

    @Test
    public void testReadindDoneCorrectly() {
        SiteHolder holder = csvReader.getSites();
        Site expected = new Site(12000, "example.com/csv1", true, new BigDecimal(454));
        expected.setKeywords(csvReader.getKeywordService().resolveKeywords(expected));
        Site actual = findSiteInSet(holder.getSites(), expected.getId());
        
        assertEquals(holder.collectionId, FILENAME);
        assertEquals(holder.getSites().size(), 3);
        assertTrue(ensureSiteFieldsAreReadCorrectly(expected, actual));
    }

}
