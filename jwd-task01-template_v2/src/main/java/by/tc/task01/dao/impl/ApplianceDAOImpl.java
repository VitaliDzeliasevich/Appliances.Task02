package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.AppAddControl;
import by.tc.task01.dao.command.AppGroupSearchControl;
import by.tc.task01.dao.command.adding.*;
import by.tc.task01.dao.command.searching.XMLAppSearcher;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.util.DAOUtil;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

import static by.tc.task01.dao.util.DAOUtil.*;

public class ApplianceDAOImpl implements ApplianceDAO {

	private String message = null;
	private static  String filePath;
	private static  String fileName = "App.xml";
	private static Document document;
	private static final String OVEN = "oven";
	private static final String LAPTOP = "laptop";
	private static final String REFRIGERATOR = "refrigerator";
	private static final String SPEAKERS = "speakers";
	private static final String TABLET_PC = "tabletpc";
	private static final String VACUUM_CLEANER = "vacuumcleaner";
	private static final String ALL_GROUP_SEARCH = "AllGroupSearch";

	public List<Appliance> find(Criteria criteria) throws DAOException{					//SEARCHING IN XML
		filePath = DAOUtil.getXMLPath(fileName);										//GETTING FILEPATH BY FILENAME
		document = getDoc(filePath); 													//GETTING DOC
		String groupSearchName = criteria.getGroupSearchName();
		List<Appliance> applianceList;

		if (criteria.getCriteriaMap().isEmpty()) { //SEARCHING WITHOUT CRITERIA (RETURNING ALL APPS FROM DEFINITE GROUP)
			applianceList = findByGroup(document, groupSearchName);
		} else {
			List<Object> listKeys = convertKeysToList(criteria.getCriteriaMap());
			List<Object> listValues = new ArrayList<>(criteria.getCriteriaMap().values());
			if (!groupSearchName.equals(ALL_GROUP_SEARCH)) { 			//SEARCHING BY CRITERIA IN DEFINITE APP GROUP
				applianceList = findByGroupAndCriteria(document, listKeys, listValues, groupSearchName);
			} else { 										// SEARCHING ONLY BY CRITERIA (WITHOUT DEFINITE APP GROUP)
				applianceList = findByCriteria(document, listKeys, listValues);
			}
		}
		return applianceList;
	}

	public void add(Appliance appliance) throws DAOException {
		filePath = DAOUtil.getXMLPath(fileName);
		document = getDoc(filePath);
		XMLAppAdder appAdder = XMLAppAdder.getInstance();
		AppAddControl addControl = new AppAddControl(appAdder);

			addControl.add(appliance, document);

		document.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File(filePath)));
		} catch (TransformerConfigurationException e) {
			throw new DAOException("XML FILE UPDATING ERROR. CONFIGURATION ERROR");
		} catch (TransformerException e) {
			throw new DAOException("XML FILE UPDATING ERROR. CONFIGURATION ERROR");
		}
	}

	private List<Appliance> findByGroupAndCriteria(Document document, List<Object> listKeys, List<Object> listValues,
										   String groupSearchName) {
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppGroupSearchControl searchControl = new AppGroupSearchControl(searcherXML);
		List<Appliance> applianceList = new ArrayList<>();
		switch (groupSearchName) {
			case OVEN -> applianceList.addAll(searchControl.searchOven(document, listKeys, listValues));
			case LAPTOP -> applianceList.addAll(searchControl.searchLaptop(document, listKeys, listValues));
			case REFRIGERATOR -> applianceList.addAll(searchControl.searchRefrigerator(document, listKeys, listValues));
			case SPEAKERS -> applianceList.addAll(searchControl.searchSpeakers(document, listKeys, listValues));
			case TABLET_PC -> applianceList.addAll(searchControl.searchTabletPC(document, listKeys, listValues));
			case VACUUM_CLEANER -> applianceList.addAll(searchControl.searchVacuumCleaner(document, listKeys, listValues));
		}
		return applianceList;
	}

	private List<Appliance> findByCriteria(Document document, List<Object> listKeys,
											List<Object> listValues) {
		List<Appliance> applianceList = new ArrayList<>();
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppGroupSearchControl searchControl = new AppGroupSearchControl(searcherXML);

		applianceList.addAll(searchControl.searchOven(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchLaptop(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchRefrigerator(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchSpeakers(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchTabletPC(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchVacuumCleaner(document, listKeys, listValues));

		return applianceList;
	}

	private List<Appliance> findByGroup(Document document, String groupSearchName) {
		List<Appliance> applianceList = new ArrayList<>();
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppGroupSearchControl searchControl = new AppGroupSearchControl(searcherXML);

		switch (groupSearchName) {
			case OVEN -> applianceList.addAll(searchControl.searchOven(document));
			case LAPTOP -> applianceList.addAll(searchControl.searchLaptop(document));
			case REFRIGERATOR -> applianceList.addAll(searchControl.searchRefrigerator(document));
			case SPEAKERS -> applianceList.addAll(searchControl.searchSpeakers(document));
			case TABLET_PC -> applianceList.addAll(searchControl.searchTabletPC(document));
			case VACUUM_CLEANER -> applianceList.addAll(searchControl.searchVacuumCleaner(document));
		}

		return applianceList;
	}


}



