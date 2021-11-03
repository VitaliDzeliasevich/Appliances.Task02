package by.tc.task01.dao.command.adding;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;

public interface AddCommand {
    void execute(Appliance app, Document document);
}
