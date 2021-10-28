package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{


	public List<Appliance> find(Criteria criteria) throws RuntimeException{
		if (!Validator.criteriaValidator(criteria)) {
			throw new RuntimeException("Incorrect Criteria");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> appliance = applianceDAO.find(criteria);
		
		// you may add your own code here
		
		return appliance;
	}


	public void add(Appliance appliance) {


		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		applianceDAO.add(appliance);

		// you may add your own code here

	}
}

//you may add your own new classes
