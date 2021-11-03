package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	} // creating Object for contacting Database

	public static DAOFactory getInstance() {
		return instance;
	} // creating factory itself (STATIC METHOD)
}
