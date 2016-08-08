package rubicon.serialization;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import rubicon.model.Site;

public class SiteJsonDeserializer extends JsonDeserializer<Site> {

    public static final String ID = "site_id";
    public static final String NAME = "name";
    public static final String MOBILE = "mobile";
    public static final String SCORE = "score";

    @Override
    public Site deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser);

        return new Site(node.get(ID).asInt(), 
                node.get(NAME).asText(), 
                node.get(MOBILE).asBoolean(),
                new BigDecimal(node.get(SCORE).asText()));
    }

}
