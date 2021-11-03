package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance{

    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double height;
    private double width;
    private double overallCapacity;

    public Refrigerator() {}

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity, double height,
                                                            double width, double overallCapacity) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.height = height;
        this.width = width;
        this.overallCapacity = overallCapacity;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption && weight == that.weight && freezerCapacity == that.freezerCapacity && Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0 && Double.compare(that.overallCapacity, overallCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, height, width, overallCapacity);
    }

    @Override
    public String toString() {
        return "Refrigerator[" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", height=" + height +
                ", width=" + width +
                ", overallCapacity=" + overallCapacity +
                ']';
    }
}
