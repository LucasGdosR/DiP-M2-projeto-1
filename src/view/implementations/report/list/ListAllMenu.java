package view.implementations.report.list;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class ListAllMenu extends LeafMenu {
    public ListAllMenu(Menu previousMenu, Controller controller) {
        super("Listar Todos", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.listAll();
        previousMenu.act();
    }
}
