package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SpeakersAddCommand implements AddCommand {



    public SpeakersAddCommand() {}

    public void execute(Appliance app, Document document) {

        NodeList nodeList = document.getElementsByTagName("Speakerss");

        Element speakers = document.createElement("speakers");

        Element powerConsumption = document.createElement("POWER_CONSUMPTION");
        powerConsumption.appendChild(document.createTextNode(String.valueOf(app.getPowerConsumption())));
        speakers.appendChild(powerConsumption);

        Element numberOfSpeakers = document.createElement("NUMBER_OF_SPEAKERS");
        numberOfSpeakers.appendChild(document.createTextNode(String.valueOf(app.getNumberOfSpeakers())));
        speakers.appendChild(numberOfSpeakers);

        Element frequencyRange = document.createElement("FREQUENCY_RANGE");
        frequencyRange.appendChild(document.createTextNode(app.getFrequencyRange()));
        speakers.appendChild(frequencyRange);

        Element cordLength = document.createElement("CORD_LENGTH");
        cordLength.appendChild(document.createTextNode(String.valueOf(app.getCordLength())));
        speakers.appendChild(cordLength);


        nodeList.item(0).appendChild(speakers);
    }
}
