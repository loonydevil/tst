package rubicon.parse;

import java.io.File;
import java.math.BigDecimal;
import java.util.Set;

import rubicon.model.Site;
import rubicon.model.SiteHolder;
import rubiconproject.KeywordService;

public abstract class Reader {
    
    private File file;
    private KeywordService keywordService;

    /**
     * Utility method to create site from parsed String values.
     * @param id
     * @param name
     * @param mobile
     * @param score
     * @return Site created from input parameters.
     */
    protected Site createSite(String id, String name, String mobile, String score) {
        Site site = new Site(Integer.parseInt(id), name, Boolean.valueOf(mobile), new BigDecimal(score));
        return site;
    }
    
    /**
     * Sets keywords to List of provided Sites.
     * @param sites
     */
    protected void populateKeywords(Set<Site> sites) {
        for (Site site : sites) {
            site.setKeywords(keywordService.resolveKeywords(site));
        }
    }
    
    /**
     * Performs reading of supplied file and conversion to output format.
     * @return SiteHolder containing collectionId and list of parsed sites.
     */
    protected abstract SiteHolder readFile();
    
    /**
     * Reads provided File and populates keywords for parsed sites.
     * @return SiteHolder containing collectionId and list of parsed sites.
     */
    public SiteHolder getSites() {
        SiteHolder holder = readFile();
        populateKeywords(holder.getSites());
        return holder;
    }

    public File getFile() {
        return file;
    }

    protected void setFile(File file) {
        this.file = file;
    }

    protected KeywordService getKeywordService() {
        return keywordService;
    }

    protected void setKeywordService(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

}
