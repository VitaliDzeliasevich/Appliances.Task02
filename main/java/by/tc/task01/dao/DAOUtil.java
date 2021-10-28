package by.tc.task01.dao;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public final class DAOUtil {


    private static List<Object> listKeys;
    private static List<Object> listValues;



    private DAOUtil() {}

    public static List<Appliance> findAppliances(String dataBasePath, Criteria criteria) {
        List<Appliance> applianceList = new ArrayList<>();
        listKeys = convertKeysToList(criteria.getCriteriaMap());
        listValues = convertValuesToList(criteria.getCriteriaMap());
        String groupSearchName = criteria.getGroupSearchName();
        try {
            Document document = getDoc(dataBasePath);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(groupSearchName);

            switch (groupSearchName) {
                case "Oven":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getOven(nodeList.item(i)));
                    }
                    break;
                case "Laptop":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getLaptop(nodeList.item(i)));
                    }

                    break;
                case "Refrigerator":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getRefrigerator(nodeList.item(i)));
                    }

                    break;
                case "Speakers":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getSpeakers(nodeList.item(i)));
                    }
                    break;
                case "TabletPC":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getTabletPC(nodeList.item(i)));
                    }
                    break;
                case "VacuumCleaner":
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        applianceList.addAll(getVacuumCleaner(nodeList.item(i)));
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applianceList;
    }

     private static Document getDoc(String XMLpath) {
        File fileXML = new File(XMLpath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document document = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileXML);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

     private static List<Oven> getOven(Node node) {
         Oven oven = new Oven();
         List<Oven> ovens= new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
         if (node.getNodeType() == Node.ELEMENT_NODE) {
             Element element = (Element) node;
             double ELEMENT_POWER_CONSUMPTION = Double.parseDouble(getTagValue("POWER_CONSUMPTION", element));
             double ELEMENT_CAPACITY = Double.parseDouble(getTagValue("CAPACITY", element));
             double ELEMENT_DEPTH = Double.parseDouble(getTagValue("DEPTH", element));
             double ELEMENT_HEIGHT = Double.parseDouble(getTagValue("HEIGHT", element));
             double ELEMENT_WEIGHT = Double.parseDouble(getTagValue("WEIGHT", element));
             double ELEMENT_WIDTH = Double.parseDouble(getTagValue("WIDTH", element));
             int k=0;
                 while (k<listKeys.size()) {
                     if (((listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)) ||
                             (listKeys.get(k).equals("CAPACITY") && listValues.get(k).equals(ELEMENT_CAPACITY)) ||
                             (listKeys.get(k).equals("DEPTH") && listValues.get(k).equals(ELEMENT_DEPTH)) ||
                             (listKeys.get(k).equals("HEIGHT") && listValues.get(k).equals(ELEMENT_HEIGHT)) ||
                             (listKeys.get(k).equals("WEIGHT") && listValues.get(k).equals(ELEMENT_WEIGHT)) ||
                             (listKeys.get(k).equals("WIDTH") && listValues.get(k).equals(ELEMENT_WIDTH))) && k+1<listKeys.size()) {
                        k++;
                     }
                     else if (((listKeys.get(k).equals("POWER_CONSUMPTION") && listValues.get(k).equals(ELEMENT_POWER_CONSUMPTION)) ||
                             (listKeys.get(k).equals("CAPACITY") && listValues.get(k).equals(ELEMENT_CAPACITY)) ||
                             (listKeys.get(k).equals("DEPTH") && listValues.get(k).equals(ELEMENT_DEPTH)) ||
                             (listKeys.get(k).equals("HEIGHT") && listValues.get(k).equals(ELEMENT_HEIGHT)) ||
                             (listKeys.get(k).equals("WEIGHT") && listValues.get(k).equals(ELEMENT_WEIGHT)) ||
                             (listKeys.get(k).equals("WIDTH") && listValues.get(k).equals(ELEMENT_WIDTH))) && k+1==listKeys.size()) {
                         oven.setPowerConsumption((int)ELEMENT_POWER_CONSUMPTION);
                         oven.setCapacity((int)ELEMENT_CAPACITY);
                         oven.setDepth((int)ELEMENT_DEPTH);
                         oven.setHeight(ELEMENT_HEIGHT);
                         oven.setWeight((int)ELEMENT_WEIGHT);
                         oven.setWidth(ELEMENT_WIDTH);
                         ovens.add(oven);
                         k++;
                     }
                     else break;
                 }
                 }
         return ovens;
     }


     private static List<Laptop> getLaptop(Node node) {
         Laptop laptop = new Laptop();
         List<Laptop> laptops = new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
         if (node.getNodeType() == Node.ELEMENT_NODE) {
             Element element = (Element) node;
             double ELEMENT_BATTERY_CAPACITY = Double.parseDouble(getTagValue("BATTERY_CAPACITY", element));
             String ELEMENT_OS = getTagValue("OS", element);
             double ELEMENT_MEMORY_ROM = Integer.parseInt(getTagValue("MEMORY_ROM", element));
             double ELEMENT_SYSTEM_MEMORY = Integer.parseInt(getTagValue("SYSTEM_MEMORY", element));
             double ELEMENT_CPU = Double.parseDouble(getTagValue("CPU", element));
             double ELEMENT_DISPLAY_INCHES = Double.parseDouble(getTagValue("DISPLAY_INCHES", element));
             int i=0;
             while (i<listKeys.size()) {
                 if (((listKeys.get(i).equals("BATTERY_CAPACITY") && listValues.get(i).equals(ELEMENT_BATTERY_CAPACITY)) ||
                         (listKeys.get(i).equals("OS") && listValues.get(i).equals(ELEMENT_OS)) ||
                         (listKeys.get(i).equals("SYSTEM_MEMORY") && listValues.get(i).equals(ELEMENT_SYSTEM_MEMORY)) ||
                         (listKeys.get(i).equals("MEMORY_ROM") && listValues.get(i).equals(ELEMENT_MEMORY_ROM)) ||
                         (listKeys.get(i).equals("CPU") && listValues.get(i).equals(ELEMENT_CPU)) ||
                         (listKeys.get(i).equals("DISPLAY_INCHES") && listValues.get(i).equals(ELEMENT_DISPLAY_INCHES))) && i+1<listKeys.size()) {
                     i++;
                 }
                 else if (((listKeys.get(i).equals("BATTERY_CAPACITY") && listValues.get(i).equals(ELEMENT_BATTERY_CAPACITY)) ||
                         (listKeys.get(i).equals("OS") && listValues.get(i).equals(ELEMENT_OS)) ||
                         (listKeys.get(i).equals("SYSTEM_MEMORY") && listValues.get(i).equals(ELEMENT_SYSTEM_MEMORY)) ||
                         (listKeys.get(i).equals("MEMORY_ROM") && listValues.get(i).equals(ELEMENT_MEMORY_ROM)) ||
                         (listKeys.get(i).equals("CPU") && listValues.get(i).equals(ELEMENT_CPU)) ||
                         (listKeys.get(i).equals("DISPLAY_INCHES") && listValues.get(i).equals(ELEMENT_DISPLAY_INCHES))) && i+1==listKeys.size()) {
                     laptop.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                     laptop.setOS(ELEMENT_OS);
                     laptop.setMemoryRom((int)ELEMENT_SYSTEM_MEMORY);
                     laptop.setSystemMemory((int)ELEMENT_MEMORY_ROM);
                     laptop.setCPU(ELEMENT_CPU);
                     laptop.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                     laptops.add(laptop);
                     i++;
                 }
                 else break;
             }
         }
             return laptops;

    }

     private static List<Refrigerator> getRefrigerator(Node node) {
        Refrigerator refrigerator = new Refrigerator();
         List<Refrigerator> refrigerators = new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            double ELEMENT_POWER_CONSUMPTION = Integer.parseInt(getTagValue("POWER_CONSUMPTION", element));
            double ELEMENT_WEIGHT = Integer.parseInt(getTagValue("WEIGHT", element));
            double ELEMENT_FREEZER_CAPACITY = Integer.parseInt(getTagValue("FREEZER_CAPACITY", element));
            double ELEMENT_HEIGHT = Integer.parseInt(getTagValue("HEIGHT", element));
            double ELEMENT_OVERALL_CAPACITY = Double.parseDouble(getTagValue("OVERALL_CAPACITY", element));
            double ELEMENT_WIDTH = Integer.parseInt(getTagValue("WIDTH", element));
            int i=0;
            while (i<listKeys.size()) {
                if (((listKeys.get(i).equals("POWER_CONSUMPTION") && listValues.get(i).equals(ELEMENT_POWER_CONSUMPTION)) ||
                        (listKeys.get(i).equals("WEIGHT") && listValues.get(i).equals(ELEMENT_WEIGHT)) ||
                        (listKeys.get(i).equals("FREEZER_CAPACITY") && listValues.get(i).equals(ELEMENT_FREEZER_CAPACITY)) ||
                        (listKeys.get(i).equals("HEIGHT") && listValues.get(i).equals(ELEMENT_HEIGHT)) ||
                        (listKeys.get(i).equals("OVERALL_CAPACITY") && listValues.get(i).equals(ELEMENT_OVERALL_CAPACITY)) ||
                        (listKeys.get(i).equals("WIDTH") && listValues.get(i).equals(ELEMENT_WIDTH))) && i + 1 < listKeys.size()) {
                    i++;
                } else if (((listKeys.get(i).equals("POWER_CONSUMPTION") && listValues.get(i).equals(ELEMENT_POWER_CONSUMPTION)) ||
                        (listKeys.get(i).equals("WEIGHT") && listValues.get(i).equals(ELEMENT_WEIGHT)) ||
                        (listKeys.get(i).equals("FREEZER_CAPACITY") && listValues.get(i).equals(ELEMENT_FREEZER_CAPACITY)) ||
                        (listKeys.get(i).equals("HEIGHT") && listValues.get(i).equals(ELEMENT_HEIGHT)) ||
                        (listKeys.get(i).equals("OVERALL_CAPACITY") && listValues.get(i).equals(ELEMENT_OVERALL_CAPACITY)) ||
                        (listKeys.get(i).equals("WIDTH") && listValues.get(i).equals(ELEMENT_WIDTH))) && i + 1 == listKeys.size()) {
                    refrigerator.setPowerConsumption((int)ELEMENT_POWER_CONSUMPTION);
                    refrigerator.setWeight((int)ELEMENT_WEIGHT);
                    refrigerator.setFreezerCapacity((int)ELEMENT_FREEZER_CAPACITY);
                    refrigerator.setHeight((int)ELEMENT_HEIGHT);
                    refrigerator.setOverallCapacity(ELEMENT_OVERALL_CAPACITY);
                    refrigerator.setWidth((int)ELEMENT_WIDTH);
                    refrigerators.add(refrigerator);
                    i++;
                } else break;
            }
        }
        return refrigerators;
    }

     private static List<Speakers> getSpeakers(Node node) {
        Speakers speakers = new Speakers();
         List<Speakers> speakerss = new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            double ELEMENT_POWER_CONSUMPTION = Integer.parseInt(getTagValue("POWER_CONSUMPTION", element));
            double ELEMENT_NUMBER_OF_SPEAKERS = Integer.parseInt(getTagValue("NUMBER_OF_SPEAKERS", element));
            String ELEMENT_FREQUENCY_RANGE = getTagValue("FREQUENCY_RANGE", element);
            double ELEMENT_CORD_LENGTH = Integer.parseInt(getTagValue("CORD_LENGTH", element));
            int i=0;
            while (i<listKeys.size()) {
                if (((listKeys.get(i).equals("POWER_CONSUMPTION") && listValues.get(i).equals(ELEMENT_POWER_CONSUMPTION)) ||
                        (listKeys.get(i).equals("NUMBER_OF_SPEAKERS") && listValues.get(i).equals(ELEMENT_NUMBER_OF_SPEAKERS)) ||
                        (listKeys.get(i).equals("FREQUENCY_RANGE") && listValues.get(i).equals(ELEMENT_FREQUENCY_RANGE)) ||
                        (listKeys.get(i).equals("CORD_LENGTH") && listValues.get(i).equals(ELEMENT_CORD_LENGTH)))  && i + 1 < listKeys.size()) {
                    i++;
                } else if (((listKeys.get(i).equals("POWER_CONSUMPTION") && listValues.get(i).equals(ELEMENT_POWER_CONSUMPTION)) ||
                        (listKeys.get(i).equals("NUMBER_OF_SPEAKERS") && listValues.get(i).equals(ELEMENT_NUMBER_OF_SPEAKERS)) ||
                        (listKeys.get(i).equals("FREQUENCY_RANGE") && listValues.get(i).equals(ELEMENT_FREQUENCY_RANGE)) ||
                        (listKeys.get(i).equals("CORD_LENGTH") && listValues.get(i).equals(ELEMENT_CORD_LENGTH))) && i + 1 == listKeys.size()) {
                    speakers.setPowerConsumption((int)ELEMENT_POWER_CONSUMPTION);
                    speakers.setNumberOfSpeakers((int)ELEMENT_NUMBER_OF_SPEAKERS);
                    speakers.setFrequencyRange(ELEMENT_FREQUENCY_RANGE);
                    speakers.setCordLength((int)ELEMENT_CORD_LENGTH);
                    speakerss.add(speakers);
                    i++;
                } else break;
            }
        }
        return speakerss;
    }

     private static List<TabletPC> getTabletPC(Node node) {
        TabletPC tablet = new TabletPC();
         List<TabletPC> tablets = new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            double ELEMENT_BATTERY_CAPACITY = Double.parseDouble(getTagValue("BATTERY_CAPACITY", element));
            String ELEMENT_COLOR = getTagValue("COLOR", element);
            double ELEMENT_FLASH_MEMORY_CAPACITY = Integer.parseInt(getTagValue("FLASH_MEMORY_CAPACITY", element));
            double ELEMENT_MEMORY_ROM = Integer.parseInt(getTagValue("MEMORY_ROM", element));
            double ELEMENT_DISPLAY_INCHES = Double.parseDouble(getTagValue("DISPLAY_INCHES", element));
            int i = 0;
            while (i < listKeys.size()) {
                if (((listKeys.get(i).equals("BATTERY_CAPACITY") && listValues.get(i).equals(ELEMENT_BATTERY_CAPACITY)) ||
                        (listKeys.get(i).equals("COLOR") && listValues.get(i).equals(ELEMENT_COLOR)) ||
                        (listKeys.get(i).equals("FLASH_MEMORY_CAPACITY") && listValues.get(i).equals(ELEMENT_FLASH_MEMORY_CAPACITY)) ||
                        (listKeys.get(i).equals("MEMORY_ROM") && listValues.get(i).equals(ELEMENT_MEMORY_ROM)) ||
                        (listKeys.get(i).equals("DISPLAY_INCHES") && listValues.get(i).equals(ELEMENT_DISPLAY_INCHES))) && i + 1 < listKeys.size()) {
                    i++;
                } else if (((listKeys.get(i).equals("BATTERY_CAPACITY") && listValues.get(i).equals(ELEMENT_BATTERY_CAPACITY)) ||
                        (listKeys.get(i).equals("COLOR") && listValues.get(i).equals(ELEMENT_COLOR)) ||
                        (listKeys.get(i).equals("FLASH_MEMORY_CAPACITY") && listValues.get(i).equals(ELEMENT_FLASH_MEMORY_CAPACITY)) ||
                        (listKeys.get(i).equals("MEMORY_ROM") && listValues.get(i).equals(ELEMENT_MEMORY_ROM)) ||
                        (listKeys.get(i).equals("DISPLAY_INCHES") && listValues.get(i).equals(ELEMENT_DISPLAY_INCHES))) && i + 1 == listKeys.size()) {
                    tablet.setBatteryCapacity(ELEMENT_BATTERY_CAPACITY);
                    tablet.setColor(ELEMENT_COLOR);
                    tablet.setFlashMemoryCapacity((int)ELEMENT_FLASH_MEMORY_CAPACITY);
                    tablet.setMemoryRom((int)ELEMENT_MEMORY_ROM);
                    tablet.setDisplayInches(ELEMENT_DISPLAY_INCHES);
                    tablets.add(tablet);
                    i++;
                } else break;
            }
        }
        return tablets;
    }

     private static List<VacuumCleaner> getVacuumCleaner(Node node) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
         List<VacuumCleaner> cleaners = new ArrayList<>();
         List<Object> listKeys = DAOUtil.listKeys;
         List<Object> listValues = DAOUtil.listValues;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            vacuumCleaner.setBagType(getTagValue("BAG_TYPE", element));
            vacuumCleaner.setFilterType(getTagValue("FILTER_TYPE", element));
            vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(getTagValue("MOTOR_SPEED_REGULATION", element)));
            vacuumCleaner.setCleaningWidth(Integer.parseInt(getTagValue("CLEANING_WIDTH", element)));
            vacuumCleaner.setWandType(getTagValue("WAND_TYPE", element));
            vacuumCleaner.setPowerConsumption(Integer.parseInt(getTagValue("POWER_CONSUMPTION", element)));
        }
        return cleaners;
    }

     private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    private static List<Object> convertKeysToList(Map<String, Object> map) {
        Set<String> keys = map.keySet();
        Object[] arrayKeys = keys.toArray();
        List<Object> listKeys = new ArrayList<>();
        listKeys.addAll(Arrays.asList(arrayKeys));
        return listKeys;
    }

    private static List<Object> convertValuesToList(Map<String, Object> map) {
        return new ArrayList<>(map.values());
    }

}
