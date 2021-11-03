package by.tc.task01.dao.command;

import by.tc.task01.dao.command.searching.SearchCommand;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import java.util.List;

public class AppGroupSearchControl {
    private final SearchCommand searchOven;
    private final SearchCommand searchLaptop;
    private final SearchCommand searchRefrigerator;
    private final SearchCommand searchSpeakers;
    private final SearchCommand searchTabletPC;
    private final SearchCommand searchVacuumCleaner;

    public AppGroupSearchControl(SearchCommand searchOven, SearchCommand searchLaptop,
                                 SearchCommand searchRefrigerator, SearchCommand searchSpeakers,
                                 SearchCommand searchTabletPC, SearchCommand searchVacuumCleaner) {
        this.searchOven=searchOven;
        this.searchLaptop=searchLaptop;
        this.searchRefrigerator=searchRefrigerator;
        this.searchSpeakers=searchSpeakers;
        this.searchTabletPC=searchTabletPC;
        this.searchVacuumCleaner=searchVacuumCleaner;
    }

    public List<Appliance> searchOven(Document document, List<Object> listKeys, List<Object> listValues) {
            return searchOven.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchLaptop(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchLaptop.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchRefrigerator(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchRefrigerator.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchSpeakers(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchSpeakers.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchTabletPC(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchTabletPC.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchVacuumCleaner(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchVacuumCleaner.execute(document, listKeys, listValues);
    }
}
