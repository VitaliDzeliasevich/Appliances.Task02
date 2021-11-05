package by.tc.task01.service.validation;

import by.tc.task01.entity.*;
import by.tc.task01.service.exception.ServiceException;

public class AppValidator {
    public static void validate(Appliance appliance) throws ServiceException {
        boolean valid = false;
        String message = null;
        if (appliance instanceof Laptop) {
            if (isValid(appliance.getBatteryCapacity()) && isValid(appliance.getOS())
                    && isValid(appliance.getMemoryRom()) && isValid(appliance.getSystemMemory()) &&
                    isValid(appliance.getCPU()) && isValid(appliance.getDisplayInches())) {
                valid = true;
            } else message = "INVALID LAPTOP CHARACTERISTICS";
        } else if (appliance instanceof Oven) {
            if (isValid(appliance.getPowerConsumption()) && isValid(appliance.getWeight())
                    && isValid(appliance.getCapacity()) && isValid(appliance.getDepth()) &&
                    isValid(appliance.getHeight()) && isValid(appliance.getWeight())) {
                valid = true;
            } else message = "INVALID OVEN CHARACTERISTICS";
        } else if (appliance instanceof Refrigerator) {
            if (isValid(appliance.getPowerConsumption()) && isValid(appliance.getWeight())
                    && isValid(appliance.getFreezerCapacity()) && isValid(appliance.getOverallCapacity()) &&
                    isValid(appliance.getHeight()) && isValid(appliance.getWeight())) {
                valid = true;
            } else message = "INVALID REFRIGERATOR CHARACTERISTICS";
        } else if (appliance instanceof Speakers) {
            if (isValid(appliance.getPowerConsumption()) && isValid(appliance.getNumberOfSpeakers())
                    && isValid(appliance.getCordLength()) && isValid(appliance.getFrequencyRange())) {
                valid = true;
            } else message = "INVALID SPEAKERS CHARACTERISTICS";
        } else if (appliance instanceof TabletPC) {
            if (isValid(appliance.getBatteryCapacity()) && isValid(appliance.getDisplayInches())
                    && isValid(appliance.getMemoryRom()) && isValid(appliance.getFlashMemoryCapacity()) &&
                    isValid(appliance.getColor())) {
                valid = true;
            } else message = "INVALID TABLET_PC CHARACTERISTICS";
        } else if (appliance instanceof VacuumCleaner) {
            if (isValid(appliance.getPowerConsumption()) && isValid(appliance.getMotorSpeedRegulation())
                    && isValid(appliance.getCleaningWidth()) && isValid(appliance.getFilterType()) &&
                    isValid(appliance.getWandType()) && isValid(appliance.getBagType())) {
                valid = true;
            } else message = "INVALID VACUUM_CLEANER CHARACTERISTICS";
        }
        if (!valid)
            throw new ServiceException(message);
    }

    private static boolean isValid(String field) {
        return field != null && !field.isEmpty();
    }

    private static boolean isValid(int field) {
        return !(field <= 0);
    }

    private static boolean isValid(double field) {
        return !(field <= 0);
    }
}
