package by.tc.task01.dao.command.searching.impl;

import by.tc.task01.dao.command.searching.SearchCommand;
import by.tc.task01.dao.command.searching.XMLAppSearcher;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

import java.util.List;

public class OvenSearcherCommand implements SearchCommand {

    private final XMLAppSearcher XMLSearcher;

    public OvenSearcherCommand(XMLAppSearcher searcher) {
        this.XMLSearcher = searcher;
    }

    public List<Appliance> execute(Document document, List<Object> listKeys, List<Object> listValues) {
        return XMLSearcher.searchOven(document, listKeys, listValues);
    }

    public List<Appliance> execute(Document document) {
        return XMLSearcher.searchOven(document, null, null);
    }
}
