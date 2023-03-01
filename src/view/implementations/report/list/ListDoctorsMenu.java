package view.implementations.report.list;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class ListDoctorsMenu extends LeafMenu {
    public ListDoctorsMenu(Menu previousMenu, Controller controller) {
        super("Listar Médicos", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.listDoctors();
        previousMenu.act();
    }
}
