package by.tc.task01.dao.command.adding.impl;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LaptopAddCommand implements AddCommand {


    public LaptopAddCommand(){}

    public void execute(Appliance app, Document document) {

            NodeList nodeList = document.getElementsByTagName("Laptops");
            Element laptop = document.createElement("laptop");

            Element batteryCapacity = document.createElement("BATTERY_CAPACITY");
            batteryCapacity.appendChild(document.createTextNode(String.valueOf(app.getBatteryCapacity())));
            laptop.appendChild(batteryCapacity);

            Element oS = document.createElement("OS");
            oS.appendChild(document.createTextNode(app.getOS()));
            laptop.appendChild(oS);

            Element memoryRom = document.createElement("MEMORY_ROM");
            memoryRom.appendChild(document.createTextNode(String.valueOf(app.getMemoryRom())));
            laptop.appendChild(memoryRom);

            Element systemMemory = document.createElement("SYSTEM_MEMORY");
            systemMemory.appendChild(document.createTextNode(String.valueOf(app.getSystemMemory())));
            laptop.appendChild(systemMemory);

            Element cpu = document.createElement("CPU");
            cpu.appendChild(document.createTextNode(String.valueOf(app.getCPU())));
            laptop.appendChild(cpu);

            Element displayInches = document.createElement("DISPLAY_INCHES");
            displayInches.appendChild(document.createTextNode(String.valueOf(app.getDisplayInches())));
            laptop.appendChild(displayInches);


            nodeList.item(0).appendChild(laptop);
        }
}
