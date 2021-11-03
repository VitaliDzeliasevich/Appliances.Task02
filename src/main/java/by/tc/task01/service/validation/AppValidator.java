package by.tc.task01.service.validation;

import by.tc.task01.entity.*;

public class AppValidator {
    public static boolean creatingValidator(Appliance appliance) {
        if (appliance instanceof Laptop) {
            if (isValidate(appliance.getBatteryCapacity()) && isValidate(appliance.getOS())
                    && isValidate(appliance.getMemoryRom()) && isValidate(appliance.getSystemMemory()) &&
                    isValidate(appliance.getCPU()) && isValidate(appliance.getDisplayInches())) {
                return true;
            } else throw new RuntimeException("ADDING LAPTOP TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        } else if (appliance instanceof Oven) {
            if (isValidate(appliance.getPowerConsumption()) && isValidate(appliance.getWeight())
                    && isValidate(appliance.getCapacity()) && isValidate(appliance.getDepth()) &&
                    isValidate(appliance.getHeight()) && isValidate(appliance.getWeight())) {
                return true;
            } else throw new RuntimeException("ADDING OVEN TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        } else if (appliance instanceof Refrigerator) {
            if (isValidate(appliance.getPowerConsumption()) && isValidate(appliance.getWeight())
                    && isValidate(appliance.getFreezerCapacity()) && isValidate(appliance.getOverallCapacity()) &&
                    isValidate(appliance.getHeight()) && isValidate(appliance.getWeight())) {
                return true;
            } else throw new RuntimeException("ADDING REFRIGERATOR TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        } else if (appliance instanceof Speakers) {
            if (isValidate(appliance.getPowerConsumption()) && isValidate(appliance.getNumberOfSpeakers())
                    && isValidate(appliance.getCordLength()) && isValidate(appliance.getFrequencyRange())) {
                return true;
            } else throw new RuntimeException("ADDING SPEAKERS TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        }
        else if (appliance instanceof TabletPC) {
            if (isValidate(appliance.getBatteryCapacity()) && isValidate(appliance.getDisplayInches())
                    && isValidate(appliance.getMemoryRom()) && isValidate(appliance.getFlashMemoryCapacity()) &&
                    isValidate(appliance.getColor())) {
                return true;
            } else throw new RuntimeException("ADDING TABLET_PC TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        } else if (appliance instanceof VacuumCleaner) {
            if (isValidate(appliance.getPowerConsumption()) && isValidate(appliance.getMotorSpeedRegulation())
                    && isValidate(appliance.getCleaningWidth()) && isValidate(appliance.getFilterType()) &&
                    isValidate(appliance.getWandType()) && isValidate(appliance.getBagType())) {
                return true;
            } else throw new RuntimeException("ADDING VACUUM_CLEANER TO XML IS STOPPED BECAUSE OF INVALID CHARACTERISTICS");
        }
        return false;
    }

    private static boolean isValidate(String field) {
        return !field.equals("");
    }

    private static   boolean isValidate(int field) {
        return !(field<=0);
    }

    private static   boolean isValidate(double field) {
        return !(field<=0);
    }
}
