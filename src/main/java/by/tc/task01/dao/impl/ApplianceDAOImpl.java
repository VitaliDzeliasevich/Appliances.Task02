package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.AppAddControl;
import by.tc.task01.dao.command.AppGroupSearchControl;
import by.tc.task01.dao.command.adding.*;
import by.tc.task01.dao.command.searching.*;
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

	private static  String filePath;
	private static Document document;
	private static final String OVEN = "oven";
	private static final String LAPTOP = "laptop";
	private static final String REFRIGERATOR = "refrigerator";
	private static final String SPEAKERS = "speakers";
	private static final String TABLET_PC = "tabletpc";
	private static final String VACUUM_CLEANER = "vacuumcleaner";
	private static final String ALL_GROUP_SEARCH = "AllGroupSearch";

	public List<Appliance> find(Criteria criteria) { //SEARCHING IN XML
		filePath = DAOUtil.getXMLPath("Appliances.xml");
		document = getDoc(filePath);
		String groupSearchName = criteria.getGroupSearchName();
		List<Appliance> applianceList;

		XMLAppSearcher searcherXML = new XMLAppSearcher();
		SearchCommand ovenSearcher = new OvenSearcherCommand(searcherXML);
		SearchCommand laptopSearcher = new LaptopSearcherCommand(searcherXML);
		SearchCommand refrigeratorSearcher = new RefrigeratorSearcherCommand(searcherXML);
		SearchCommand speakersSearcher = new SpeakersSearcherCommand(searcherXML);
		SearchCommand tabletSearcher = new TabletPCSearcherCommand(searcherXML);
		SearchCommand vacuumSearcher = new VacuumCleanerSearcherCommand(searcherXML);
		AppGroupSearchControl searchControl = new AppGroupSearchControl(ovenSearcher, laptopSearcher,
				                                 refrigeratorSearcher, speakersSearcher,tabletSearcher,vacuumSearcher);

		if (criteria.getCriteriaMap().isEmpty()) { //SEARCHING WITHOUT CRITERIA (RETURNING ALL APPS FROM DEFINITE GROUP)
			applianceList = findByGroup(document, searchControl, groupSearchName);
		} else {
			List<Object> listKeys = convertKeysToList(criteria.getCriteriaMap());
			List<Object> listValues = new ArrayList<>(criteria.getCriteriaMap().values());
			if (!groupSearchName.equals(ALL_GROUP_SEARCH)) { //SEARCHING BY CRITERIA IN DEFINITE APP GROUP
				applianceList = findByGroupAndCriteria(document, listKeys, listValues, searchControl, groupSearchName);
			} else { // SEARCHING ONLY BY CRITERIA (WITHOUT DEFINITE APP GROUP)
				applianceList = findByCriteria(document, listKeys, listValues, searchControl);
			}
		}
		return applianceList;

	}

	public void add(Appliance appliance) { //ADDING APP TO THE XML
			document = getDoc(filePath);

			XMLAppAdder appAdder = new XMLAppAdder();
			AddCommand ovenAdder = new OvenAddCommand(appAdder);
			AddCommand laptopAdder = new LaptopAddCommand(appAdder);
			AddCommand refrigeratorAdder = new RefrigeratorAddCommand(appAdder);
			AddCommand speakersAdder = new SpeakersAddCommand(appAdder);
			AddCommand tabletpcAdder = new TabletPCAddCommand(appAdder);
			AddCommand vacuumCleanerAdder = new VacuumCleanerAddCommand(appAdder);
			AppAddControl addControl = new AppAddControl(laptopAdder,ovenAdder,refrigeratorAdder,speakersAdder,
					tabletpcAdder,vacuumCleanerAdder);

			String appGroupName = appliance.getClass().getSimpleName().toLowerCase();

		switch (appGroupName) {
			case OVEN -> addControl.addOven(appliance, document);
			case LAPTOP -> addControl.addLaptop(appliance, document);
			case REFRIGERATOR -> addControl.addRefrigerator(appliance, document);
			case SPEAKERS -> addControl.addSpeakers(appliance, document);
			case TABLET_PC -> addControl.addTabletPC(appliance, document);
			case VACUUM_CLEANER -> addControl.addVacuumCleaner(appliance, document);
		}

		document.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File(filePath)));
		} catch (TransformerConfigurationException e) {
			System.out.println("XML FILE UPDATING ERROR");
		} catch (TransformerException e) {
			System.out.println("XML FILE UPDATING ERROR");;
		}
	}

	private List<Appliance> findByGroupAndCriteria(Document document, List<Object> listKeys, List<Object> listValues,
										   AppGroupSearchControl searchControl, String groupSearchName) {
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
											List<Object> listValues, AppGroupSearchControl searchControl) {
		List<Appliance> applianceList = new ArrayList<>();

		applianceList.addAll(searchControl.searchOven(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchLaptop(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchRefrigerator(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchSpeakers(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchTabletPC(document, listKeys, listValues));
		applianceList.addAll(searchControl.searchVacuumCleaner(document, listKeys, listValues));

		return applianceList;
	}

	private List<Appliance> findByGroup(Document document, AppGroupSearchControl searchControl, String groupSearchName) {
		List<Appliance> applianceList = new ArrayList<>();

		switch (groupSearchName) {
			case OVEN -> applianceList.addAll(searchControl.searchOven(document, null, null));
			case LAPTOP -> applianceList.addAll(searchControl.searchLaptop(document, null, null));
			case REFRIGERATOR -> applianceList.addAll(searchControl.searchRefrigerator(document, null, null));
			case SPEAKERS -> applianceList.addAll(searchControl.searchSpeakers(document, null, null));
			case TABLET_PC -> applianceList.addAll(searchControl.searchTabletPC(document, null, null));
			case VACUUM_CLEANER -> applianceList.addAll(searchControl.searchVacuumCleaner(document, null, null));
		}

		return applianceList;
	}


}



