package by.tc.task01.dao.util;

import by.tc.task01.dao.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public final class DAOUtil {

    private DAOUtil() {}

    public static String getXMLPath(String fileName) throws DAOException{
        final URL fileURL = DAOUtil.class.getClassLoader().getResource(fileName);
        String XMLPath=null;
        try {
            XMLPath = fileURL.getPath();
        } catch (NullPointerException e) {
            throw new DAOException("XMLFILE IS NULL. CHECK FILENAME");
        }
        return XMLPath;
    }

    public static Document getDoc(String XMLpath) throws DAOException{
        File fileXML = new File(XMLpath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document document = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileXML);
            document.getDocumentElement().normalize();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException("DOCUMENT PARSING EXCEPTION");
        }
        return document;
    }

    public static String getTagValue(String tag, Element element){
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
