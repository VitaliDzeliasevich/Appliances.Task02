package by.tc.task01.dao.command;

import by.tc.task01.dao.command.searching.*;
import by.tc.task01.dao.command.searching.impl.*;
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

    public AppGroupSearchControl(XMLAppSearcher appSearcher) {
        this.searchOven = new OvenSearcherCommand(appSearcher);
        this.searchLaptop= new LaptopSearcherCommand(appSearcher);
        this.searchRefrigerator= new RefrigeratorSearcherCommand(appSearcher);
        this.searchSpeakers= new SpeakersSearcherCommand(appSearcher);
        this.searchTabletPC= new TabletPCSearcherCommand(appSearcher);
        this.searchVacuumCleaner= new VacuumCleanerSearcherCommand(appSearcher);

    }

    public List<Appliance> searchOven(Document document, List<Object> listKeys, List<Object> listValues) {
            return searchOven.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchOven(Document document) {
        return searchOven.execute(document);
    }

    public List<Appliance> searchLaptop(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchLaptop.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchLaptop(Document document) {
        return searchLaptop.execute(document);
    }

    public List<Appliance> searchRefrigerator(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchRefrigerator.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchRefrigerator(Document document) {
        return searchRefrigerator.execute(document);
    }

    public List<Appliance> searchSpeakers(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchSpeakers.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchSpeakers(Document document) {
        return searchSpeakers.execute(document);
    }

    public List<Appliance> searchTabletPC(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchTabletPC.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchTabletPC(Document document) {
        return searchTabletPC.execute(document);
    }

    public List<Appliance> searchVacuumCleaner(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchVacuumCleaner.execute(document, listKeys, listValues);
    }

    public List<Appliance> searchVacuumCleaner(Document document) {
        return searchVacuumCleaner.execute(document);
    }
}
