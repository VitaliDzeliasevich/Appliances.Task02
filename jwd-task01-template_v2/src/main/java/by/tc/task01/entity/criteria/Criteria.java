package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private final String groupSearchName;
	private final Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName.toLowerCase();
	}

	public Criteria() {
		this.groupSearchName = "AllGroupSearch";
	}

	public void add(String searchCriteria, Object value) {
		if (value instanceof String) {
			criteria.put(searchCriteria, ((String) value).toUpperCase());
		}
		else if (value instanceof Integer) {
			double doubleValue = (int) (Integer) value;

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

}
