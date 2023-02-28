package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class RegisterDoctorMenu extends LeafMenu {
    public RegisterDoctorMenu(Menu previousMenu, Controller controller) {
        super("Registrar Médico", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.registerDoctor();
        previousMenu.act();
    }
}
