package by.tc.task01.view;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliance) {
        if (appliance.isEmpty()) {
            System.out.println("NO APP IS FOUND ON YOUR REQUEST.");
        } else {
            int numberOfFoundApps = appliance.size();
            if (numberOfFoundApps ==1) { System.out.println("1 APP IS FOUND ON YOUR REQUEST:"); }
            else { System.out.println(numberOfFoundApps + " APPS ARE FOUND ON YOUR REQUEST:");
                for (Appliance app : appliance) {
                    System.out.println(app.toString());
                }
            }
        }
    }
}
