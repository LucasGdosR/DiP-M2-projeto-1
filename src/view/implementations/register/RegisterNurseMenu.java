package view.implementations.register;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class RegisterNurseMenu extends LeafMenu {
    public RegisterNurseMenu(Menu previousMenu, Controller controller) {
        super("Registrar Enfermeiro", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.registerNurse();
        previousMenu.act();
    }
}
