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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class DAOUtil {

    private DAOUtil() {}

    public static String getXMLPath(String fileName) {
        final URL fileURL = DAOUtil.class.getClassLoader().getResource(fileName);
        String XMLPath;
        if (fileURL==null) {
            throw new RuntimeException("FILE IS NOT FOUND. CHECK FILENAME!");
        }
        else {
             XMLPath = fileURL.getPath();
        }
        return XMLPath;
    }

    public static Document getDocFromXML(String XMLPath) throws DAOException{
        File fileXML = new File(XMLPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document document;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileXML);
            document.getDocumentElement().normalize();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException("DOCUMENT PARSING EXCEPTION:   " + e);
        }
        return document;
    }

    public static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }


    public static void updateXMLFile(Document document, String filePath) throws DAOException{
        document.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(new File(filePath)));
        } catch (TransformerConfigurationException e) {
            throw new DAOException("XML FILE UPDATING ERROR. CONFIGURATION ERROR:  " + e);
        } catch (TransformerException e) {
            throw new DAOException("XML FILE UPDATING ERROR. CONFIGURATION ERROR:  " + e);
        }
    }

}
