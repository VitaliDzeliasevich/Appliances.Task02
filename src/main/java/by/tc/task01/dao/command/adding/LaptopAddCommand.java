package by.tc.task01.dao.command.adding;

import by.tc.task01.dao.command.searching.XMLAppSearcher;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class LaptopAddCommand implements AddCommand{

    private final XMLAppAdder xmlAppAdder;

    public LaptopAddCommand(XMLAppAdder adder) {
        this.xmlAppAdder = adder;
    }

    public void execute(Appliance app, Document document) {
       xmlAppAdder.addLaptop(app, document);
    }
}
