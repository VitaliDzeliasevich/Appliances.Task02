package by.tc.task01.dao;

import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria) throws DAOException;

	void add(Appliance app) throws DAOException;
}
