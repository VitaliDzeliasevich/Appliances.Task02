package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.AppAddControl;
import by.tc.task01.dao.command.AppSearchControl;
import by.tc.task01.dao.command.searching.XMLAppSearcher;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.util.DAOUtil;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;

import java.util.*;

import static by.tc.task01.dao.util.DAOUtil.*;

public class ApplianceDAOImpl implements ApplianceDAO {

	private static String filePath;
	private static Document document;
	private static final String FILE_NAME = "App.xml";
	private static final String ALL_GROUP_SEARCH = SearchCriteria.ALL_GROUP_SEARCH;

	public List<Appliance> find(Criteria criteria) throws DAOException{					//SEARCHING IN XML
		filePath = DAOUtil.getXMLPath(FILE_NAME);										//GETTING FILEPATH BY FILENAME
		document = getDocFromXML(filePath); 											//GETTING DOC
		String groupSearchName = criteria.getGroupSearchName();
		List<Appliance> applianceList;

		if (criteria.getCriteriaMap().isEmpty()) { //SEARCHING WITHOUT CRITERIA (RETURNING ALL APPS FROM DEFINITE GROUP)
			applianceList = findByGroup(document, groupSearchName);
		} else {
			List<Object> characteristicList = new ArrayList<>(criteria.getCriteriaMap().keySet());
			List<Object> characteristicValueList = new ArrayList<>(criteria.getCriteriaMap().values());
			if (!groupSearchName.equals(ALL_GROUP_SEARCH)) { 			//SEARCHING BY CRITERIA IN DEFINITE APP GROUP
				applianceList = findByGroupAndCriteria(document, characteristicList, characteristicValueList, groupSearchName);
			} else { 										//SEARCHING ONLY BY CRITERIA (WITHOUT DEFINITE APP GROUP)
				applianceList = findByCriteria(document, characteristicList, characteristicValueList);
			}
		}
		return applianceList;
	}

	public void add(Appliance appliance) throws DAOException {
		filePath = DAOUtil.getXMLPath(FILE_NAME);
		document = getDocFromXML(filePath);
		AppAddControl addControl = AppAddControl.getInstance();
			addControl.add(appliance, document);
		DAOUtil.updateXMLFile(document,filePath);
	}

	private List<Appliance> findByGroupAndCriteria(Document document, List<Object> characteristicList, List<Object>
																							characteristicValueList,
										   													String groupSearchName) {
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppSearchControl searchControl = new AppSearchControl(searcherXML);
		return new ArrayList<>(searchControl.searchApp(document, characteristicList, characteristicValueList, groupSearchName));
	}

	private List<Appliance> findByCriteria(Document document, List<Object> characteristicList,
											List<Object> characteristicValueList) {
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppSearchControl searchControl = new AppSearchControl(searcherXML);
		return new ArrayList<>(searchControl.searchApp(document, characteristicList, characteristicValueList));
	}

	private List<Appliance> findByGroup(Document document, String groupSearchName) {
		XMLAppSearcher searcherXML = XMLAppSearcher.getInstance();
		AppSearchControl searchControl = new AppSearchControl(searcherXML);
		return new ArrayList<>(searchControl.searchApp(document,groupSearchName));
	}
}



