package by.tc.task01.dao.command;

import by.tc.task01.dao.command.adding.*;
import by.tc.task01.dao.command.adding.impl.*;
import by.tc.task01.entity.*;
import org.w3c.dom.Document;

public class AppAddControl {
    private final AddCommand laptopAddCommand;
    private final AddCommand ovenAddCommand;
    private final AddCommand refrigeratorAddCommand;
    private final AddCommand speakersAddCommand;
    private final AddCommand tabletPCAddCommand;
    private final AddCommand vacuumCleanerAddCommand;

    public AppAddControl(XMLAppAdder appAdder) {
        this.laptopAddCommand = new LaptopAddCommand(appAdder);
        this.ovenAddCommand = new OvenAddCommand(appAdder);
        this.refrigeratorAddCommand = new RefrigeratorAddCommand(appAdder);
        this.speakersAddCommand = new SpeakersAddCommand(appAdder);
        this.tabletPCAddCommand = new TabletPCAddCommand(appAdder);
        this.vacuumCleanerAddCommand = new VacuumCleanerAddCommand(appAdder);
    }

    public void add(Appliance appliance, Document document) {
        if (appliance instanceof Oven) {addOven(appliance,document);}
        else if (appliance instanceof Laptop) {addLaptop(appliance,document);}
        else if (appliance instanceof Refrigerator) {addRefrigerator(appliance,document);}
        else if (appliance instanceof Speakers) {addSpeakers(appliance,document);}
        else if (appliance instanceof TabletPC) {addTabletPC(appliance,document);}
        else if (appliance instanceof VacuumCleaner) {addVacuumCleaner(appliance,document);}
    }

    private void addOven(Appliance appliance, Document document) {
        ovenAddCommand.execute(appliance,document);
    }

    private void addLaptop(Appliance appliance, Document document) {

        laptopAddCommand.execute(appliance,document);
    }

    private void addRefrigerator(Appliance appliance, Document document) {
        refrigeratorAddCommand.execute(appliance,document);
    }

    private void addSpeakers(Appliance appliance, Document document) {

        speakersAddCommand.execute(appliance,document);
    }

    private void addTabletPC(Appliance appliance, Document document) {

        tabletPCAddCommand.execute(appliance,document);
    }

    private void addVacuumCleaner(Appliance appliance, Document document) {
        vacuumCleanerAddCommand.execute(appliance,document);
    }
}
