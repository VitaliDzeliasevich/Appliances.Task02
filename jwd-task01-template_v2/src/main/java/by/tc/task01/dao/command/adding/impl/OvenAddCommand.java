package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.dao.command.adding.XMLAppAdder;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public class OvenAddCommand implements AddCommand {

    private final XMLAppAdder xmlAppAdder;

    public OvenAddCommand(XMLAppAdder adder) {
        this.xmlAppAdder = adder;
    }

    public void execute(Appliance app, Document document) {
        xmlAppAdder.addOven(app, document);
    }
}
