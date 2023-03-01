package view.implementations.report.list;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class ListPatientsMenu extends LeafMenu {
    public ListPatientsMenu(Menu previousMenu, Controller controller) {
        super("Listar Pacientes", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.listPatients();
        previousMenu.act();
    }
}
