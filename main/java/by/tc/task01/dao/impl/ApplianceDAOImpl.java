package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOUtil;
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
import java.util.Map.Entry;

public class ApplianceDAOImpl implements ApplianceDAO {

	public List<Appliance> find(Criteria criteria) {
		// you may add your own code here; request for DataBase
		String filepath = "src/main/resources/DataBase";
		List<Appliance> result = DAOUtil.findAppliances(filepath, criteria);

		return result;
	}

	public void add(Appliance appliance) {
	}
	// you may add your own code here; pushing object to database


	/////////////////////////////////////////////////////////////////////////////////////////////////////


}



