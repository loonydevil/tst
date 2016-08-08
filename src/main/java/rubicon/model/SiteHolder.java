package rubicon.model;

import java.util.Set;

public class SiteHolder {

    public String collectionId;
    
    public Set<Site> sites;
    
    public SiteHolder(String collectionId, Set<Site> sites) {
        this.collectionId = collectionId;
        this.sites = sites;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public Set<Site> getSites() {
        return sites;
    }

    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }

    @Override
    public String toString() {
        return "SiteHolder [collectionId=" + collectionId + ", sites=" + sites + "]";
    }
}
