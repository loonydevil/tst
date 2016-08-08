package rubicon.parse;

import java.util.Set;
import java.util.stream.Collectors;

import rubicon.model.Site;

public class ReaderTestBase {
    
    protected boolean ensureSiteFieldsAreReadCorrectly(Site expected, Site actual) {
        return expected.getId() == actual.getId() &&
                expected.getKeywords().equals(actual.getKeywords()) &&
                expected.getName().equals(actual.getName()) &&
                expected.getScore().equals(actual.getScore()) &&
                expected.isMobile() == actual.isMobile();
    }
    
    protected Site findSiteInSet(Set<Site> sites, int id) {
        return sites.stream().filter(s -> s.getId() == id).collect(Collectors.toList()).get(0);
    }

}
