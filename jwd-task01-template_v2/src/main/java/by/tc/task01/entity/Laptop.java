package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public class Laptop extends Appliance {

    private double batteryCapacity;
    private String OS;
    private int memoryRom;
    private int systemMemory;
    private double CPU;
    private double displayInches;

    public Laptop() {}

    public Laptop(double batteryCapacity, String OS, int memoryRom, int systemMemory, double CPU, double displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.OS = OS.toUpperCase();
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOS() {
        return OS;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setOS(String OS) {
        this.OS = OS.toUpperCase();
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return batteryCapacity == laptop.batteryCapacity && memoryRom == laptop.memoryRom && systemMemory == laptop.systemMemory && Double.compare(laptop.CPU, CPU) == 0 && displayInches == laptop.displayInches && Objects.equals(OS, laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, OS, memoryRom, systemMemory, CPU, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop[" +
                "batteryCapacity=" + batteryCapacity +
                ", OS='" + OS + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", CPU=" + CPU +
                ", displayInches=" + displayInches +
                ']';
    }
}
