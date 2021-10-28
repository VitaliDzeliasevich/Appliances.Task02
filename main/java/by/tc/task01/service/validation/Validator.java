package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) throws RuntimeException{
		// you may add your own code here; checking if we have suggested criteria
		Map<String, Object> criteriaMap = criteria.getCriteriaMap();
		List<Object> criteriaValues =new ArrayList<>(criteriaMap.values());
		for (int i=0; i<criteriaValues.size(); i++) {
			if (criteriaValues.get(i) instanceof Double && (Double)criteriaValues.get(i)<=0) {
				throw new RuntimeException("Invalid criteria parameters");
			}
		}

		return true;
	}

}

