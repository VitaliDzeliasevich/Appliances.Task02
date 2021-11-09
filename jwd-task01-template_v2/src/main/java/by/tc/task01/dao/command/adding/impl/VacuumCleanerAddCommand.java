package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VacuumCleanerAddCommand implements AddCommand {


    public VacuumCleanerAddCommand() {}

    public void execute(Appliance app, Document document) {

        NodeList nodeList = document.getElementsByTagName("VacuumCleaners");

        Element vacuumcleaner = document.createElement("vacuumcleaner");

        Element powerConsumption = document.createElement("POWER_CONSUMPTION");
        powerConsumption.appendChild(document.createTextNode(String.valueOf(app.getPowerConsumption())));
        vacuumcleaner.appendChild(powerConsumption);

        Element filterType = document.createElement("FILTER_TYPE");
        filterType.appendChild(document.createTextNode(app.getFilterType()));
        vacuumcleaner.appendChild(filterType);

        Element bagType = document.createElement("BAG_TYPE");
        bagType.appendChild(document.createTextNode(app.getBagType()));
        vacuumcleaner.appendChild(bagType);

        Element wandType = document.createElement("WAND_TYPE");
        wandType.appendChild(document.createTextNode(app.getWandType()));
        vacuumcleaner.appendChild(wandType);

        Element motorSpeedRegulation = document.createElement("MOTOR_SPEED_REGULATION");
        motorSpeedRegulation.appendChild(document.createTextNode(String.valueOf(app.getMotorSpeedRegulation())));
        vacuumcleaner.appendChild(motorSpeedRegulation);

        Element cleaningWidth = document.createElement("CLEANING_WIDTH");
        cleaningWidth.appendChild(document.createTextNode(String.valueOf(app.getCleaningWidth())));
        vacuumcleaner.appendChild(cleaningWidth);

        nodeList.item(0).appendChild(vacuumcleaner);
    }
}