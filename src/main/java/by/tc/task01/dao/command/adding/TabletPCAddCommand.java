package by.tc.task01.dao.command.adding;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public class TabletPCAddCommand implements AddCommand{

    private final XMLAppAdder xmlAppAdder;

    public TabletPCAddCommand(XMLAppAdder adder) {
        this.xmlAppAdder = adder;
    }

    public void execute(Appliance app, Document document) {
        xmlAppAdder.addTabletPC(app, document);
    }
}
