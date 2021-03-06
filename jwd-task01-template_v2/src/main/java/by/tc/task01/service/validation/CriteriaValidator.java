package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.exception.ServiceException;

import java.util.*;

public class CriteriaValidator {

	public static void validate(Criteria criteria) throws ServiceException {
		Map<String, Object> criteriaMap = criteria.getCriteriaMap();
		String groupSearchName = criteria.getGroupSearchName().toLowerCase();
		List<Object> criteriaValues =new ArrayList<>(criteriaMap.values());
		for (int i=0; i<criteriaValues.size(); i++) {
			if (criteriaValues.get(i) instanceof Double && (Double)criteriaValues.get(i)<=0) {
				throw new ServiceException("INVALID CRITERIA PARAMETER! MUST BE MORE THAN 0: " + criteriaValues.get(i));
			}
		}

		if (!((groupSearchName.equals(SearchCriteria.Oven.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals(SearchCriteria.Laptop.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals(SearchCriteria.Refrigerator.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals(SearchCriteria.Speakers.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals(SearchCriteria.TabletPC.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals(SearchCriteria.VacuumCleaner.class.getSimpleName().toLowerCase())) ||
				(groupSearchName.equals("allgroupsearch")))) {
			throw new ServiceException("SEARCH GROUP IS NOT FOUND: " + criteria.getGroupSearchName());
		}
	}
}

