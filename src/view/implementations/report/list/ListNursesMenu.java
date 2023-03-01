package view.implementations.report.list;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class ListNursesMenu extends LeafMenu {
    public ListNursesMenu(Menu previousMenu, Controller controller) {
        super("Listar Enfermeiros", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.listNurses();
        previousMenu.act();
    }
}
