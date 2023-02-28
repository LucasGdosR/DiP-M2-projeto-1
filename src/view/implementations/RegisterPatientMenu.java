package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class RegisterPatientMenu extends LeafMenu {
    public RegisterPatientMenu(Menu previousMenu, Controller controller) {
        super("Registrar Paciente", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.registerPatient();
        previousMenu.act();
    }
}
