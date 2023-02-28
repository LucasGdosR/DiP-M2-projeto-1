package view.implementations.factory;

import controller.Controller;
import view.CompositeMenu;
import view.Menu;
import view.implementations.*;

public class MainMenuFactory {
    public Menu create(Controller controller) {
        CompositeMenu mainMenu = new MainMenu();

        mainMenu.addSubmenu(new ExitMenu(mainMenu));
        mainMenu.addSubmenu(new RegisterPatientMenu(mainMenu, controller));
        mainMenu.addSubmenu(new RegisterNurseMenu(mainMenu, controller));
        mainMenu.addSubmenu(new RegisterDoctorMenu(mainMenu, controller));
        mainMenu.addSubmenu(new PerformMedicalProcedureMenu(mainMenu, controller));
        mainMenu.addSubmenu(new UpdatePatientStatusMenu(mainMenu, controller));

        CompositeMenu mainReportMenu = new MainReportMenu(mainMenu);
        mainReportMenu.addSubmenu(new PreviousMenu(mainMenu));
        mainReportMenu.addSubmenu(new PatientReportMenu(mainReportMenu, controller));
        mainReportMenu.addSubmenu(new NurseReportMenu(mainReportMenu, controller));
        mainReportMenu.addSubmenu(new DoctorReportMenu(mainReportMenu, controller));
        mainReportMenu.addSubmenu(new FullReportMenu(mainReportMenu, controller));

        mainMenu.addSubmenu(mainReportMenu);

        return mainMenu;
    }
}
