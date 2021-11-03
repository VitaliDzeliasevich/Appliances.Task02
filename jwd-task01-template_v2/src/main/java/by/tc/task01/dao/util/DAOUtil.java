package by.tc.task01.dao.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.*;

public final class DAOUtil {

    private DAOUtil() {}

    public static String getXMLPath(String fileName) {
        final URL fileURL = DAOUtil.class.getClassLoader().getResource(fileName);
        String filePath=null;
        try {
            filePath = fileURL.getPath();
        } catch (NullPointerException e) {
            System.out.println("FILE IS NOT FOUND. CHECK FILENAME. CURRENT FILENAME:  "+fileName);
        }
        return filePath;
    }

    public static Document getDoc(String XMLpath) {
        File fileXML = new File(XMLpath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document document = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileXML);
            document.getDocumentElement().normalize();
        }
        catch (Exception e) {
            System.out.println("DOCUMENT IS NOT FOUND. CHECK XML FILE PATH.");
        }
        return document;
    }

    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static List<Object> convertKeysToList(Map<String, Object> map) {
        Set<String> keys = map.keySet();
        Object[] arrayKeys = keys.toArray();
        return new ArrayList<>(Arrays.asList(arrayKeys));
    }

}
