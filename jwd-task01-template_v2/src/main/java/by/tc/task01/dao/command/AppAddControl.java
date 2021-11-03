package by.tc.task01.dao.command;

import by.tc.task01.dao.command.adding.AddCommand;
import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public class AppAddControl {
    private final AddCommand laptopAddCommand;
    private final AddCommand ovenAddCommand;
    private final AddCommand refrigeratorAddCommand;
    private final AddCommand speakersAddCommand;
    private final AddCommand tabletPCAddCommand;
    private final AddCommand vacuumCleanerAddCommand;

    public AppAddControl(AddCommand laptopAddCommand, AddCommand ovenAddCommand,
                         AddCommand refrigeratorAddCommand, AddCommand speakersAddCommand,
                         AddCommand tabletPCAddCommand, AddCommand vacuumCleanerAddCommand) {
        this.laptopAddCommand = laptopAddCommand;
        this.ovenAddCommand = ovenAddCommand;
        this.refrigeratorAddCommand = refrigeratorAddCommand;
        this.speakersAddCommand = speakersAddCommand;
        this.tabletPCAddCommand = tabletPCAddCommand;
        this.vacuumCleanerAddCommand = vacuumCleanerAddCommand;
    }

    public void addOven(Appliance appliance, Document document) {
        ovenAddCommand.execute(appliance,document);
    }

    public void addLaptop(Appliance appliance, Document document) {
        laptopAddCommand.execute(appliance,document);
    }

    public void addRefrigerator(Appliance appliance, Document document) {
        refrigeratorAddCommand.execute(appliance,document);
    }

    public void addSpeakers(Appliance appliance, Document document) {
        speakersAddCommand.execute(appliance,document);
    }

    public void addTabletPC(Appliance appliance, Document document) {
        tabletPCAddCommand.execute(appliance,document);
    }

    public void addVacuumCleaner(Appliance appliance, Document document) {
        vacuumCleanerAddCommand.execute(appliance,document);
    }
}
