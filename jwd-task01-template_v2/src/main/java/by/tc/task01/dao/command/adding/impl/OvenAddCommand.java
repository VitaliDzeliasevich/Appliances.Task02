package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class OvenAddCommand implements AddCommand {

    public OvenAddCommand() {}

    public void execute(Appliance app, Document document) {

        NodeList nodeList = document.getElementsByTagName("Ovens");

        Element oven = document.createElement("oven");

        Element powerConsumption = document.createElement("POWER_CONSUMPTION");
        powerConsumption.appendChild(document.createTextNode(String.valueOf(app.getPowerConsumption())));
        oven.appendChild(powerConsumption);

        Element weight = document.createElement("WEIGHT");
        weight.appendChild(document.createTextNode(String.valueOf(app.getWeight())));
        oven.appendChild(weight);

        Element capacity = document.createElement("CAPACITY");
        capacity.appendChild(document.createTextNode(String.valueOf(app.getCapacity())));
        oven.appendChild(capacity);

        Element depth = document.createElement("DEPTH");
        depth.appendChild(document.createTextNode(String.valueOf(app.getDepth())));
        oven.appendChild(depth);

        Element height = document.createElement("HEIGHT");
        height.appendChild(document.createTextNode(String.valueOf(app.getHeight())));
        oven.appendChild(height);

        Element width = document.createElement("WIDTH");
        width.appendChild(document.createTextNode(String.valueOf(app.getWidth())));
        oven.appendChild(width);

        nodeList.item(0).appendChild(oven);
    }

}

