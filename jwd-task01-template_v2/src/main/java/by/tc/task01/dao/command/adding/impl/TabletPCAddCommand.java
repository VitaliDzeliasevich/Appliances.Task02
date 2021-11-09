package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TabletPCAddCommand implements AddCommand {



    public TabletPCAddCommand() { }

    public void execute(Appliance app, Document document) {

        NodeList nodeList = document.getElementsByTagName("TabletPCs");

        Element tabletpc = document.createElement("tabletpc");

        Element batteryCapacity = document.createElement("BATTERY_CAPACITY");
        batteryCapacity.appendChild(document.createTextNode(String.valueOf(app.getBatteryCapacity())));
        tabletpc.appendChild(batteryCapacity);

        Element displayInches = document.createElement("DISPLAY_INCHES");
        displayInches.appendChild(document.createTextNode(String.valueOf(app.getDisplayInches())));
        tabletpc.appendChild(displayInches);

        Element memoryRom = document.createElement("MEMORY_ROM");
        memoryRom.appendChild(document.createTextNode(String.valueOf(app.getMemoryRom())));
        tabletpc.appendChild(memoryRom);

        Element flashMemoryCapacity = document.createElement("FLASH_MEMORY_CAPACITY");
        flashMemoryCapacity.appendChild(document.createTextNode(String.valueOf(app.getFlashMemoryCapacity())));
        tabletpc.appendChild(flashMemoryCapacity);

        Element color = document.createElement("COLOR");
        color.appendChild(document.createTextNode(app.getColor()));
        tabletpc.appendChild(color);


        nodeList.item(0).appendChild(tabletpc);
    }
}
