package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private String groupSearchName;
	private Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		if (value instanceof String) {
			criteria.put(searchCriteria, ((String) value).toUpperCase());
		}
		else if (value instanceof Integer) {
			int integerValue = (Integer) value;
			double doubleValue =  integerValue;

			criteria.put(searchCriteria, doubleValue);
		}
		else {
			criteria.put(searchCriteria, value);
		}
	}

	public Map<String, Object> getCriteriaMap() {
		return criteria;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}




	// you may add your own code here

}
