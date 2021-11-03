package by.tc.task01.entity;

import java.util.Objects;

public class VacuumCleaner extends Appliance{

    private int powerConsumption;
    private int motorSpeedRegulation;
    private int cleaningWidth;
    private String filterType;
    private String bagType;
    private String wandType;

    public VacuumCleaner() {}

    public VacuumCleaner(int powerConsumption, int motorSpeedRegulation, int cleaningWidth, String filterType,
                         String bagType, String wandType) {
        this.powerConsumption = powerConsumption;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
        this.filterType = filterType.toUpperCase();
        this.bagType = bagType.toUpperCase();
        this.wandType = wandType.toUpperCase();
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType.toUpperCase();
    }

    public void setBagType(String bagType) {
        this.bagType = bagType.toUpperCase();
    }

    public void setWandType(String wandType) {
        this.wandType = wandType.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return powerConsumption == that.powerConsumption && motorSpeedRegulation == that.motorSpeedRegulation && cleaningWidth == that.cleaningWidth && Objects.equals(filterType, that.filterType) && Objects.equals(bagType, that.bagType) && Objects.equals(wandType, that.wandType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, motorSpeedRegulation, cleaningWidth, filterType, bagType, wandType);
    }

    @Override
    public String toString() {
        return "VacuumCleaner[" +
                "powerConsumption=" + powerConsumption +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ']';
    }
}
