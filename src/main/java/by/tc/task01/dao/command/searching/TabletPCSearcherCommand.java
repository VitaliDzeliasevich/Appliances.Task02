package by.tc.task01.dao.command.searching;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

import java.util.List;

public class TabletPCSearcherCommand implements SearchCommand {

    private final XMLAppSearcher XMLSearcher;

    public TabletPCSearcherCommand(XMLAppSearcher searcher) {
        this.XMLSearcher = searcher;
    }

    public List<Appliance> execute(Document document, List<Object> listKeys, List<Object> listValues) {
        return XMLSearcher.searchTabletPC(document, listKeys, listValues);
    }
}