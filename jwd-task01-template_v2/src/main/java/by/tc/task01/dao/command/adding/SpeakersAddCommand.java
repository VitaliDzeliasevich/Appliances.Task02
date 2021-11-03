package by.tc.task01.dao.command.adding;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public class SpeakersAddCommand implements AddCommand{

    private final XMLAppAdder xmlAppAdder;

    public SpeakersAddCommand(XMLAppAdder adder) {
        this.xmlAppAdder = adder;
    }

    public void execute(Appliance app, Document document) {
        xmlAppAdder.addSpeakers(app, document);
    }
}
