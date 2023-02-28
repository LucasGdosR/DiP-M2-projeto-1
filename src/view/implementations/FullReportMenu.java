package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class FullReportMenu extends LeafMenu {
    public FullReportMenu(Menu previousMenu, Controller controller) {
        super("Relatório de todas as pessoas", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.fullReport();
        previousMenu.act();
    }
}
