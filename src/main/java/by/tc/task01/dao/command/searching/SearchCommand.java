package by.tc.task01.dao.command.searching;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public interface SearchCommand {
    List<Appliance> execute(Document document, List<Object> listKeys, List<Object> listValues);
}
