package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.AppValidator;
import by.tc.task01.service.validation.CriteriaValidator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{


	public List<Appliance> find(Criteria criteria) {
		if (!CriteriaValidator.criteriaValidator(criteria)) {
			throw new RuntimeException("INCORRECT CRITERIA");
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		return applianceDAO.find(criteria);
	}


	public void add(Appliance appliance) {
		if (!AppValidator.creatingValidator(appliance)) {
			throw new RuntimeException("IMPOSSIBLE TO ADD TO XML " + appliance.getClass().getSimpleName());
		}



		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		applianceDAO.add(appliance);
	}
}


