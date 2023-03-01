package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class PerformMedicalProcedureMenu extends LeafMenu {
    public PerformMedicalProcedureMenu(Menu previousMenu, Controller controller) {
        super("Realizar Atendimento Médico", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.performMedicalProcedure();
        previousMenu.act();
    }
}
