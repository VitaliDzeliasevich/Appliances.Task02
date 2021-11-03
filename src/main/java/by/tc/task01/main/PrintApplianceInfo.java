package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {
		if (appliance.isEmpty()) {
			System.out.println("No appliance is found on your request.");
		}
		else {
		for (Appliance app : appliance) {
			System.out.println(app.toString());
		}
	}
}
}
