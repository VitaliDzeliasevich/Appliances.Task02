package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance{

    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private int height;
    private int width;
    private double overallCapacity;

    public Refrigerator() {}

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
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
        return powerConsumption == that.powerConsumption && weight == that.weight && freezerCapacity == that.freezerCapacity && height == that.height && width == that.width && Double.compare(that.overallCapacity, overallCapacity) == 0;
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
