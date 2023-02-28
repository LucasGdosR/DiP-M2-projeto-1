package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class DoctorReportMenu extends LeafMenu {
    public DoctorReportMenu(Menu previousMenu, Controller controller) {
        super("Relatório de Médicos", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.doctorReport();
        previousMenu.act();
    }
}
