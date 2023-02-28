package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class NurseReportMenu extends LeafMenu {
    public NurseReportMenu(Menu previousMenu, Controller controller) {
        super("Relatório de Enfermeiros", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.nurseReport();
        previousMenu.act();
    }
}
