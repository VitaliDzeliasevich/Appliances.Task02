package by.tc.task01.dao.command.searching;

import by.tc.task01.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import static by.tc.task01.dao.util.DAOUtil.getTagValue;

public class XMLAppSearcher {

    private XMLAppSearcher() {
    }

    private static final XMLAppSearcher xmlAppSearcher= new XMLAppSearcher();

    public static   XMLAppSearcher getInstance() {
        return xmlAppSearcher;
    }

    public List<Appliance> searchOven(Document document, List<Object> listKeys, List<Object> listValues) {
        Oven oven;
        List<Appliance> ovens = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("oven");


        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                double ELEMENT_POWER_CONSUMPTION = Double.parseDouble(getTagValue("POWER_CONSUMPTION", element));
                double ELEMENT_CAPACITY = Double.parseDouble(getTagValue("CAPACITY", element));
                double ELEMENT_DEPTH = Double.parseDouble(getTagValue("DEPTH", element));
                double ELEMENT_HEIGHT = Double.parseDouble(getTagValue("HEIGHT", element));
                double ELEMENT_WEIGHT = Double.parseDouble(getTagValue("WEIGHT", element));
                double ELEMENT_WIDTH = Double.parseDouble(getTagValue("WIDTH", element));
                if (listKeys == null || listValues == null) { //SEARCHING WITHOUT CRITERIA
                    oven = new Oven();
                    oven.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                    oven.setCapacity((int) ELEMENT_CAPACITY);
                    oven.setDepth((int) ELEMENT_DEPTH);
                    oven.setHeight(ELEMENT_HEIGHT);
                    oven.setWeight((int) ELEMENT_WEIGHT);
                    oven.setWidth(ELEMENT_WIDTH);
                    ovens.add(oven);
                } else {
                    int k = 0;
                    while (k < listKeys.size()) { //SEARCHING BY CRITERIA
                        if (((listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)) ||
                                (listKeys.get(k).equals("CAPACITY") && listValues.get(k).equals(ELEMENT_CAPACITY)) ||
                                (listKeys.get(k).equals("DEPTH") && listValues.get(k).equals(ELEMENT_DEPTH)) ||
                                (listKeys.get(k).equals("HEIGHT") && listValues.get(k).equals(ELEMENT_HEIGHT)) ||
                                (listKeys.get(k).equals("WEIGHT") && listValues.get(k).equals(ELEMENT_WEIGHT)) ||
                                (listKeys.get(k).equals("WIDTH") && listValues.get(k).equals(ELEMENT_WIDTH)))
                                && k + 1 <= listKeys.size()) {
                            if (k + 1 == listKeys.size()) {
                                oven = new Oven();
                                oven.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                                oven.setCapacity((int) ELEMENT_CAPACITY);
                                oven.setDepth((int) ELEMENT_DEPTH);
                                oven.setHeight(ELEMENT_HEIGHT);
                                oven.setWeight((int) ELEMENT_WEIGHT);
                                oven.setWidth(ELEMENT_WIDTH);
                                ovens.add(oven);
                            }
                            k++;

                        } else break;
                    }
                }
            }
        }
        return ovens;
    }

    public List<Appliance> searchLaptop(Document document, List<Object> listKeys, List<Object> listValues) {
        Laptop laptop;
        List<Appliance> laptops = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("laptop");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                double ELEMENT_BATTERY_CAPACITY = Double.parseDouble(getTagValue("BATTERY_CAPACITY", element));
                String ELEMENT_OS = getTagValue("OS", element);
                double ELEMENT_MEMORY_ROM = Double.parseDouble(getTagValue("MEMORY_ROM", element));
                double ELEMENT_SYSTEM_MEMORY = Double.parseDouble(getTagValue("SYSTEM_MEMORY", element));
                double ELEMENT_CPU = Double.parseDouble(getTagValue("CPU", element));
                double ELEMENT_DISPLAY_INCHES = Double.parseDouble(getTagValue("DISPLAY_INCHES", element));
                if (listKeys == null || listValues == null) {
                    laptop = new Laptop();
                    laptop.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                    laptop.setOS(ELEMENT_OS);
                    laptop.setMemoryRom((int) ELEMENT_SYSTEM_MEMORY);
                    laptop.setSystemMemory((int) ELEMENT_MEMORY_ROM);
                    laptop.setCPU(ELEMENT_CPU);
                    laptop.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                    laptops.add(laptop);
                } else {
                    int k = 0;
                    while (k < listKeys.size()) {
                        if (((listKeys.get(k).equals("BATTERY_CAPACITY") && listValues.get(k).equals(ELEMENT_BATTERY_CAPACITY)) ||
                                (listKeys.get(k).equals("OS") && listValues.get(k).equals(ELEMENT_OS)) ||
                                (listKeys.get(k).equals("SYSTEM_MEMORY") && listValues.get(k).equals(ELEMENT_SYSTEM_MEMORY)) ||
                                (listKeys.get(k).equals("MEMORY_ROM") && listValues.get(k).equals(ELEMENT_MEMORY_ROM)) ||
                                (listKeys.get(k).equals("CPU") && listValues.get(k).equals(ELEMENT_CPU)) ||
                                (listKeys.get(k).equals("DISPLAY_INCHES") && listValues.get(k).equals(ELEMENT_DISPLAY_INCHES)))
                                && k + 1 <= listKeys.size()) {
                            if (k + 1 == listKeys.size()) {
                                laptop = new Laptop();
                                laptop.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                                laptop.setOS(ELEMENT_OS);
                                laptop.setMemoryRom((int) ELEMENT_SYSTEM_MEMORY);
                                laptop.setSystemMemory((int) ELEMENT_MEMORY_ROM);
                                laptop.setCPU(ELEMENT_CPU);
                                laptop.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                                laptops.add(laptop);
                            }
                            k++;
                        } else break;
                    }
                }
            }
        }
        return laptops;

    }

    public List<Appliance> searchRefrigerator(Document document, List<Object> listKeys, List<Object> listValues) {
        Refrigerator refrigerator;
        List<Appliance> refrigerators = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("refrigerator");


        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                double ELEMENT_POWER_CONSUMPTION = Double.parseDouble(getTagValue("POWER_CONSUMPTION", element));
                double ELEMENT_WEIGHT = Double.parseDouble(getTagValue("WEIGHT", element));
                double ELEMENT_FREEZER_CAPACITY = Double.parseDouble(getTagValue("FREEZER_CAPACITY", element));
                double ELEMENT_HEIGHT = Double.parseDouble(getTagValue("HEIGHT", element));
                double ELEMENT_OVERALL_CAPACITY = Double.parseDouble(getTagValue("OVERALL_CAPACITY", element));
                double ELEMENT_WIDTH = Double.parseDouble(getTagValue("WIDTH", element));
                if (listKeys == null || listValues == null) {
                    refrigerator = new Refrigerator();
                    refrigerator.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                    refrigerator.setWeight((int) ELEMENT_WEIGHT);
                    refrigerator.setFreezerCapacity((int) ELEMENT_FREEZER_CAPACITY);
                    refrigerator.setHeight(ELEMENT_HEIGHT);
                    refrigerator.setOverallCapacity(ELEMENT_OVERALL_CAPACITY);
                    refrigerator.setWidth(ELEMENT_WIDTH);
                    refrigerators.add(refrigerator);
                } else {
                    int k = 0;
                    while (k < listKeys.size()) {
                        if (((listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)) ||
                                (listKeys.get(k).equals("WEIGHT") && listValues.get(k).equals(ELEMENT_WEIGHT)) ||
                                (listKeys.get(k).equals("FREEZER_CAPACITY") && listValues.get(k).equals(ELEMENT_FREEZER_CAPACITY)) ||
                                (listKeys.get(k).equals("HEIGHT") && listValues.get(k).equals(ELEMENT_HEIGHT)) ||
                                (listKeys.get(k).equals("OVERALL_CAPACITY") && listValues.get(k).equals(ELEMENT_OVERALL_CAPACITY)) ||
                                (listKeys.get(k).equals("WIDTH") && listValues.get(k).equals(ELEMENT_WIDTH))) && k + 1 <= listKeys.size()) {
                            if (k + 1 == listKeys.size()) {
                                refrigerator = new Refrigerator();
                                refrigerator.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                                refrigerator.setWeight((int) ELEMENT_WEIGHT);
                                refrigerator.setFreezerCapacity((int) ELEMENT_FREEZER_CAPACITY);
                                refrigerator.setHeight(ELEMENT_HEIGHT);
                                refrigerator.setOverallCapacity(ELEMENT_OVERALL_CAPACITY);
                                refrigerator.setWidth(ELEMENT_WIDTH);
                                refrigerators.add(refrigerator);
                            }
                            k++;
                        } else break;
                    }
                }
            }
        }
        return refrigerators;
    }

    public List<Appliance> searchSpeakers(Document document, List<Object> listKeys, List<Object> listValues) {
        Speakers speakers;
        List<Appliance> speakerss = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("speakers");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                double ELEMENT_POWER_CONSUMPTION = Double.parseDouble(getTagValue("POWER_CONSUMPTION", element));
                double ELEMENT_NUMBER_OF_SPEAKERS = Double.parseDouble(getTagValue("NUMBER_OF_SPEAKERS", element));
                String ELEMENT_FREQUENCY_RANGE = getTagValue("FREQUENCY_RANGE", element);
                double ELEMENT_CORD_LENGTH = Double.parseDouble(getTagValue("CORD_LENGTH", element));
                if (listKeys == null || listValues == null) {
                    speakers = new Speakers();
                    speakers.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                    speakers.setNumberOfSpeakers((int) ELEMENT_NUMBER_OF_SPEAKERS);
                    speakers.setFrequencyRange(ELEMENT_FREQUENCY_RANGE);
                    speakers.setCordLength((int) ELEMENT_CORD_LENGTH);
                    speakerss.add(speakers);
                } else {
                    int k = 0;
                    while (k < listKeys.size()) {
                        if (((listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)) ||
                                (listKeys.get(k).equals("NUMBER_OF_SPEAKERS") && listValues.get(k).equals(ELEMENT_NUMBER_OF_SPEAKERS)) ||
                                (listKeys.get(k).equals("FREQUENCY_RANGE") && listValues.get(k).equals(ELEMENT_FREQUENCY_RANGE)) ||
                                (listKeys.get(k).equals("CORD_LENGTH") && listValues.get(k).equals(ELEMENT_CORD_LENGTH)))
                                && k + 1 <= listKeys.size()) {
                            if (k + 1 == listKeys.size()) {
                                speakers = new Speakers();
                                speakers.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                                speakers.setNumberOfSpeakers((int) ELEMENT_NUMBER_OF_SPEAKERS);
                                speakers.setFrequencyRange(ELEMENT_FREQUENCY_RANGE);
                                speakers.setCordLength((int) ELEMENT_CORD_LENGTH);
                                speakerss.add(speakers);
                            }
                            k++;
                        } else break;
                    }
                }
            }
        }
        return speakerss;
    }


    public List<Appliance> searchTabletPC (Document document, List < Object > listKeys, List < Object > listValues){
            TabletPC tablet;
            List<Appliance> tablets = new ArrayList<>();
            NodeList nodeList = document.getElementsByTagName("tabletpc");

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    double ELEMENT_BATTERY_CAPACITY = Double.parseDouble(getTagValue("BATTERY_CAPACITY", element));
                    String ELEMENT_COLOR = getTagValue("COLOR", element);
                    double ELEMENT_FLASH_MEMORY_CAPACITY = Double.parseDouble(getTagValue("FLASH_MEMORY_CAPACITY", element));
                    double ELEMENT_MEMORY_ROM = Double.parseDouble(getTagValue("MEMORY_ROM", element));
                    double ELEMENT_DISPLAY_INCHES = Double.parseDouble(getTagValue("DISPLAY_INCHES", element));
                    if (listKeys == null || listValues == null) {
                        tablet = new TabletPC();
                        tablet.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                        tablet.setColor(ELEMENT_COLOR);
                        tablet.setFlashMemoryCapacity((int) ELEMENT_FLASH_MEMORY_CAPACITY);
                        tablet.setMemoryRom((int) ELEMENT_MEMORY_ROM);
                        tablet.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                        tablets.add(tablet);
                    } else {
                        int k = 0;
                        while (k < listKeys.size()) {
                            if (((listKeys.get(k).equals("BATTERY_CAPACITY") && listValues.get(k).equals(ELEMENT_BATTERY_CAPACITY)) ||
                                    (listKeys.get(k).equals("COLOR") && listValues.get(k).equals(ELEMENT_COLOR)) ||
                                    (listKeys.get(k).equals("FLASH_MEMORY_CAPACITY") && listValues.get(k).equals(ELEMENT_FLASH_MEMORY_CAPACITY)) ||
                                    (listKeys.get(k).equals("MEMORY_ROM") && listValues.get(k).equals(ELEMENT_MEMORY_ROM)) ||
                                    (listKeys.get(k).equals("DISPLAY_INCHES") && listValues.get(k).equals(ELEMENT_DISPLAY_INCHES)))
                                    && k + 1 <= listKeys.size()) {
                                if (k + 1 == listKeys.size()) {
                                    tablet = new TabletPC();
                                    tablet.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                                    tablet.setColor(ELEMENT_COLOR);
                                    tablet.setFlashMemoryCapacity((int) ELEMENT_FLASH_MEMORY_CAPACITY);
                                    tablet.setMemoryRom((int) ELEMENT_MEMORY_ROM);
                                    tablet.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                                    tablets.add(tablet);
                                }
                                k++;
                            } else break;
                        }
                    }
                }
            }
            return tablets;
        }

    public List<Appliance> searchVacuumCleaner (Document document, List < Object > listKeys, List < Object > listValues){
            VacuumCleaner vacuumCleaner;
            List<Appliance> cleaners = new ArrayList<>();

            NodeList nodeList = document.getElementsByTagName("vacuumcleaner");
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    String ELEMENT_BAG_TYPE = getTagValue("BAG_TYPE", element);
                    String ELEMENT_FILTER_TYPE = getTagValue("FILTER_TYPE", element);
                    String ELEMENT_WAND_TYPE = getTagValue("WAND_TYPE", element);
                    double ELEMENT_MOTOR_SPEED_REGULATION = Double.parseDouble(getTagValue("MOTOR_SPEED_REGULATION", element));
                    double ELEMENT_CLEANING_WIDTH = Double.parseDouble(getTagValue("CLEANING_WIDTH", element));
                    double ELEMENT_POWER_CONSUMPTION = Double.parseDouble(getTagValue("POWER_CONSUMPTION", element));
                    if (listKeys == null || listValues == null) {
                        vacuumCleaner = new VacuumCleaner();
                        vacuumCleaner.setBagType(ELEMENT_BAG_TYPE);
                        vacuumCleaner.setFilterType(ELEMENT_FILTER_TYPE);
                        vacuumCleaner.setMotorSpeedRegulation((int) ELEMENT_MOTOR_SPEED_REGULATION);
                        vacuumCleaner.setCleaningWidth((int) ELEMENT_CLEANING_WIDTH);
                        vacuumCleaner.setWandType(ELEMENT_WAND_TYPE);
                        vacuumCleaner.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                        cleaners.add(vacuumCleaner);
                    } else {
                        int k = 0;
                        while (k < listKeys.size()) {
                            if (((listKeys.get(k).equals("BAG_TYPE") && listValues.get(k).equals(ELEMENT_BAG_TYPE)) ||
                                    (listKeys.get(k).equals("FILTER_TYPE") && listValues.get(k).equals(ELEMENT_FILTER_TYPE)) ||
                                    (listKeys.get(k).equals("WAND_TYPE") && listValues.get(k).equals(ELEMENT_WAND_TYPE)) ||
                                    (listKeys.get(k).equals("MOTOR_SPEED_REGULATION") && listValues.get(k).equals(ELEMENT_MOTOR_SPEED_REGULATION)) ||
                                    (listKeys.get(k).equals("CLEANING_WIDTH") && listValues.get(k).equals(ELEMENT_CLEANING_WIDTH)) ||
                                    (listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)))
                                    && k + 1 <= listKeys.size()) {
                                if (k + 1 == listKeys.size()) {
                                    vacuumCleaner = new VacuumCleaner();
                                    vacuumCleaner.setBagType(ELEMENT_BAG_TYPE);
                                    vacuumCleaner.setFilterType(ELEMENT_FILTER_TYPE);
                                    vacuumCleaner.setMotorSpeedRegulation((int) ELEMENT_MOTOR_SPEED_REGULATION);
                                    vacuumCleaner.setCleaningWidth((int) ELEMENT_CLEANING_WIDTH);
                                    vacuumCleaner.setWandType(ELEMENT_WAND_TYPE);
                                    vacuumCleaner.setPowerConsumption((int) ELEMENT_POWER_CONSUMPTION);
                                    cleaners.add(vacuumCleaner);
                                }
                                k++;
                            } else break;
                        }
                    }
                }
            }
            return cleaners;
        }
    }

