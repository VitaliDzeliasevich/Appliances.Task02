package by.tc.task01.dao.command;

import by.tc.task01.dao.command.searching.*;
import by.tc.task01.dao.command.searching.impl.*;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;

public class AppGroupSearchControl {
    private static final String OVEN = "oven";
    private static final String LAPTOP = "laptop";
    private static final String REFRIGERATOR = "refrigerator";
    private static final String SPEAKERS = "speakers";
    private static final String TABLET_PC = "tabletpc";
    private static final String VACUUM_CLEANER = "vacuumcleaner";
    private final SearchCommand searchOven;
    private final SearchCommand searchLaptop;
    private final SearchCommand searchRefrigerator;
    private final SearchCommand searchSpeakers;
    private final SearchCommand searchTabletPC;
    private final SearchCommand searchVacuumCleaner;

    public AppGroupSearchControl(XMLAppSearcher appSearcher) {
        this.searchOven = new OvenSearcherCommand(appSearcher);
        this.searchLaptop = new LaptopSearcherCommand(appSearcher);
        this.searchRefrigerator = new RefrigeratorSearcherCommand(appSearcher);
        this.searchSpeakers = new SpeakersSearcherCommand(appSearcher);
        this.searchTabletPC = new TabletPCSearcherCommand(appSearcher);
        this.searchVacuumCleaner = new VacuumCleanerSearcherCommand(appSearcher);
    }

    public List<Appliance> searchApp(Document document, List<Object> listKeys,         //SEARCHING BY CRITERIA & GROUP
                                     List<Object> listValues, String groupSearchName) {
        List<Appliance> applianceList = new ArrayList<>();
        switch (groupSearchName) {
            case OVEN -> applianceList.addAll(searchOven(document, listKeys, listValues));
            case LAPTOP -> applianceList.addAll(searchLaptop(document, listKeys, listValues));
            case REFRIGERATOR -> applianceList.addAll(searchRefrigerator(document, listKeys, listValues));
            case SPEAKERS -> applianceList.addAll(searchSpeakers(document, listKeys, listValues));
            case TABLET_PC -> applianceList.addAll(searchTabletPC(document, listKeys, listValues));
            case VACUUM_CLEANER -> applianceList.addAll(searchVacuumCleaner(document, listKeys, listValues));
        }
        return applianceList;
    }

    public List<Appliance> searchApp(Document document, String groupSearchName) {       //SEARCHING ONLY BY GROUP
        List<Appliance> applianceList = new ArrayList<>();                              //WITHOUT CRITERIA
        switch (groupSearchName) {
            case OVEN -> applianceList.addAll(searchOven(document));
            case LAPTOP -> applianceList.addAll(searchLaptop(document));
            case REFRIGERATOR -> applianceList.addAll(searchRefrigerator(document));
            case SPEAKERS -> applianceList.addAll(searchSpeakers(document));
            case TABLET_PC -> applianceList.addAll(searchTabletPC(document));
            case VACUUM_CLEANER -> applianceList.addAll(searchVacuumCleaner(document));
        }
        return applianceList;
    }

    public List<Appliance> searchApp(Document document, List<Object> listKeys,          //SEARCHING ONLY BY CRITERIA IN
                                     List<Object> listValues) {                         //ALL GROUPS
        List<Appliance> applianceList = new ArrayList<>();
        applianceList.addAll(searchOven(document,listKeys,listValues));
        applianceList.addAll(searchLaptop(document,listKeys,listValues));
        applianceList.addAll(searchRefrigerator(document,listKeys,listValues));
        applianceList.addAll(searchSpeakers(document,listKeys,listValues));
        applianceList.addAll(searchTabletPC(document,listKeys,listValues));
        applianceList.addAll(searchVacuumCleaner(document,listKeys,listValues));
        return applianceList;
    }



    private List<Appliance> searchOven(Document document, List<Object> listKeys, List<Object> listValues) {
            return searchOven.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchOven(Document document) {
        return searchOven.execute(document);
    }

    private List<Appliance> searchLaptop(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchLaptop.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchLaptop(Document document) {
        return searchLaptop.execute(document);
    }

    private List<Appliance> searchRefrigerator(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchRefrigerator.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchRefrigerator(Document document) {
        return searchRefrigerator.execute(document);
    }

    private List<Appliance> searchSpeakers(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchSpeakers.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchSpeakers(Document document) {
        return searchSpeakers.execute(document);
    }

    private List<Appliance> searchTabletPC(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchTabletPC.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchTabletPC(Document document) {
        return searchTabletPC.execute(document);
    }

    private List<Appliance> searchVacuumCleaner(Document document, List<Object> listKeys, List<Object> listValues) {
        return searchVacuumCleaner.execute(document, listKeys, listValues);
    }

    private List<Appliance> searchVacuumCleaner(Document document) {
        return searchVacuumCleaner.execute(document);
    }
}
