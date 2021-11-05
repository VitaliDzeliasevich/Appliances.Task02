package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.exception.ServiceException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.AppValidator;
import by.tc.task01.service.validation.CriteriaValidator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {


    public List<Appliance> find(Criteria criteria) throws ServiceException {
        CriteriaValidator.validate(criteria);

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        try {
            return applianceDAO.find(criteria);
        }catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    public void add(Appliance appliance) throws ServiceException {
        AppValidator.validate(appliance);

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        try {
            applianceDAO.add(appliance);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}


