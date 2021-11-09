package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RefrigeratorAddCommand implements AddCommand {



    public RefrigeratorAddCommand() { }

    public void execute(Appliance app, Document document) {

        NodeList nodeList = document.getElementsByTagName("Refrigerators");

        Element refrigerator = document.createElement("refrigerator");

        Element powerConsumption = document.createElement("POWER_CONSUMPTION");
        powerConsumption.appendChild(document.createTextNode(String.valueOf(app.getPowerConsumption())));
        refrigerator.appendChild(powerConsumption);

        Element weight = document.createElement("WEIGHT");
        weight.appendChild(document.createTextNode(String.valueOf(app.getWeight())));
        refrigerator.appendChild(weight);

        Element freezerCapacity = document.createElement("FREEZER_CAPACITY");
        freezerCapacity.appendChild(document.createTextNode(String.valueOf(app.getFreezerCapacity())));
        refrigerator.appendChild(freezerCapacity);

        Element overallCapacity = document.createElement("OVERALL_CAPACITY");
        overallCapacity.appendChild(document.createTextNode(String.valueOf(app.getOverallCapacity())));
        refrigerator.appendChild(overallCapacity);

        Element height = document.createElement("HEIGHT");
        height.appendChild(document.createTextNode(String.valueOf(app.getHeight())));
        refrigerator.appendChild(height);

        Element width = document.createElement("WIDTH");
        width.appendChild(document.createTextNode(String.valueOf(app.getWidth())));
        refrigerator.appendChild(width);

        nodeList.item(0).appendChild(refrigerator);
    }
}
