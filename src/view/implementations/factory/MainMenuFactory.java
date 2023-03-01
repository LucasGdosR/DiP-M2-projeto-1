package view.implementations.factory;

import controller.Controller;
import view.CompositeMenu;
import view.Menu;
import view.implementations.*;
import view.implementations.register.RegisterDoctorMenu;
import view.implementations.register.RegisterNurseMenu;
import view.implementations.register.RegisterPatientMenu;
import view.implementations.report.*;
import view.implementations.report.list.*;

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
        mainMenu.addSubmenu(mainReportMenu);

        mainReportMenu.addSubmenu(new PreviousMenu(mainMenu));
        CompositeMenu listPeopleMenu = new ListPeopleMenu(mainReportMenu);
        mainReportMenu.addSubmenu(listPeopleMenu);

        listPeopleMenu.addSubmenu(new PreviousMenu(mainReportMenu));
        listPeopleMenu.addSubmenu(new ListPatientsMenu(listPeopleMenu, controller));
        listPeopleMenu.addSubmenu(new ListNursesMenu(listPeopleMenu, controller));
        listPeopleMenu.addSubmenu(new ListDoctorsMenu(listPeopleMenu, controller));
        listPeopleMenu.addSubmenu(new ListAllMenu(listPeopleMenu, controller));

        mainReportMenu.addSubmenu(new PatientReportMenu(mainReportMenu, controller));
        mainReportMenu.addSubmenu(new DoctorReportMenu(mainReportMenu, controller));


        return mainMenu;
    }
}
