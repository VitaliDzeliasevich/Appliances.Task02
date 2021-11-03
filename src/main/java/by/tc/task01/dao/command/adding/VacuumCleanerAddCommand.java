package by.tc.task01.dao.command.adding;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public class VacuumCleanerAddCommand implements AddCommand{

    private final XMLAppAdder xmlAppAdder;

    public VacuumCleanerAddCommand(XMLAppAdder adder) {
        this.xmlAppAdder = adder;
    }

    public void execute(Appliance app, Document document) {
        xmlAppAdder.addVacuumCleaner(app, document);
    }
}