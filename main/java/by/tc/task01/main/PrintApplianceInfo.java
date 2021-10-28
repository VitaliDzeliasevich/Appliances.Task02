package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {
		// you may add your own code here
		for (Appliance app : appliance) {
			if (app==null) {
				System.out.println("");
			}
			else
			System.out.println(app.toString());
		}
		
	}
	
	// you may add your own code here

}
