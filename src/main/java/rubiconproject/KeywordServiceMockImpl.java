package rubiconproject;

/** 
 * Mock implementation of KeywordService.
 *
 */
public class KeywordServiceMockImpl implements KeywordService {

    @Override
    public String resolveKeywords(Object site) {
        return "dummy";
    }

}
