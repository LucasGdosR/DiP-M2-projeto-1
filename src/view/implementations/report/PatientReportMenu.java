package view.implementations.report;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class PatientReportMenu extends LeafMenu {
    public PatientReportMenu(Menu previousMenu, Controller controller) {
        super("Relatório de Pacientes", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.patientReport();
        previousMenu.act();
    }
}
