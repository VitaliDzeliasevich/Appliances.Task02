package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {
		if (appliance.isEmpty()) {
			System.out.println("NO APPLIANCE IS FOUND ON YOUR REQUEST.");
		}
		else {
		for (Appliance app : appliance) {
			System.out.println(app.toString());
		}
	}
}
}
