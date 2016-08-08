package rubicon.parse;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import rubicon.model.Site;
import rubicon.model.SiteHolder;
import rubicon.serialization.SiteJsonDeserializer;
import rubiconproject.KeywordService;

/**
 * Extension of Reader to parse json files.
 */
public class JsonReader extends Reader {

    public JsonReader(File file, KeywordService service) {
        setKeywordService(service);
        setFile(file);
    }

    @Override
    protected SiteHolder readFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Site.class, new SiteJsonDeserializer());
        objectMapper.registerModule(module);

        try {
            Set<Site> sites = objectMapper.readValue(getFile(), new TypeReference<Set<Site>>() {});
            return new SiteHolder(getFile().getName(), sites);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
