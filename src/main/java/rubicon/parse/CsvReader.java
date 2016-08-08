package rubicon.parse;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import rubicon.model.Site;
import rubicon.model.SiteHolder;
import rubiconproject.KeywordService;

/**
 * Extension of Reader to parse csv files.
 */
public class CsvReader extends Reader {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String MOBILE = "is mobile";
    public static final String SCORE = "score";

    private static final CSVFormat csvFileFormat = 
            CSVFormat.DEFAULT.withHeader(ID, NAME, MOBILE, SCORE).withSkipHeaderRecord(true);

    public CsvReader(File file, KeywordService service) {
        setFile(file);
        setKeywordService(service);
    }

    @Override
    protected SiteHolder readFile() {
        try (FileReader fileReader = new FileReader(getFile());
             CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat)) {

            Set<Site> sites = csvFileParser.getRecords().stream()
            .map(this::createSite)
            .collect(Collectors.toSet());
            
            return new SiteHolder(getFile().getName(), sites);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected Site createSite(CSVRecord record) {
        return createSite(record.get(ID), record.get(NAME), record.get(MOBILE), record.get(SCORE));
    }
}
