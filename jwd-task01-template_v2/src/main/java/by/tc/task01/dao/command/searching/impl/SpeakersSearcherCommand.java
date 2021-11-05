package by.tc.task01.dao.command.searching.impl;

import by.tc.task01.dao.command.searching.SearchCommand;
import by.tc.task01.dao.command.searching.XMLAppSearcher;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

import java.util.List;

public class SpeakersSearcherCommand implements SearchCommand {

    private final XMLAppSearcher XMLSearcher;

    public SpeakersSearcherCommand(XMLAppSearcher searcher) {
        this.XMLSearcher = searcher;
    }

    public List<Appliance> execute(Document document, List<Object> listKeys, List<Object> listValues) {
        return XMLSearcher.searchSpeakers(document, listKeys, listValues);
    }

    public List<Appliance> execute(Document document) {
        return XMLSearcher.searchSpeakers(document, null, null);
    }
}
