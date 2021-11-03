package by.tc.task01.dao.command.adding;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

 public class XMLAppAdder {
      void addOven(Appliance app, Document document) {


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

    void addLaptop(Appliance app, Document document) {
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

    void addRefrigerator(Appliance app, Document document) {
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

    void addSpeakers(Appliance app, Document document) {
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

    void addTabletPC(Appliance app, Document document) {
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

    void addVacuumCleaner(Appliance app, Document document) {
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
