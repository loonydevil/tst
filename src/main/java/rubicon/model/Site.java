package rubicon.model;

import java.math.BigDecimal;

public class Site {
    private int id;
    private String name;
    private boolean mobile;
    private String keywords;
    private BigDecimal score;
    
    public Site() {
        //empty
    }

    public Site(int id, String name, boolean mobile, BigDecimal score) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.score = score;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Site [id=" + id + ", name=" + name + ", mobile=" + mobile + ", keywords=" + keywords + ", score=" + score + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Site other = (Site) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
