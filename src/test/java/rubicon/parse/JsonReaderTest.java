package rubicon.parse;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

import rubicon.model.Site;
import rubicon.model.SiteHolder;
import rubiconproject.KeywordServiceMockImpl;

public class JsonReaderTest extends ReaderTestBase {
    
    protected static final String PATH = "src/test/resources/input/";
    private static final String FILENAME = "input2.json";
    protected Reader jsonReader = new JsonReader(new File(PATH + FILENAME), new KeywordServiceMockImpl());

    @Test
    public void testReadindDoneCorrectly() {
        SiteHolder holder = jsonReader.getSites();
        Site expected = new Site(13000, "example.com/json1", true, new BigDecimal(21));
        expected.setKeywords(jsonReader.getKeywordService().resolveKeywords(expected));
        Site actual = findSiteInSet(holder.getSites(), expected.getId());
        
        assertEquals(holder.collectionId, FILENAME);
        assertEquals(holder.getSites().size(), 3);
        assertTrue(ensureSiteFieldsAreReadCorrectly(expected, actual));
    }

}
