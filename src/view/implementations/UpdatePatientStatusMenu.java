package view.implementations;

import controller.Controller;
import view.LeafMenu;
import view.Menu;

public class UpdatePatientStatusMenu extends LeafMenu {
    public UpdatePatientStatusMenu(Menu previousMenu, Controller controller) {
        super("Atualizar Status de Atendimento de Paciente", previousMenu, controller);
    }

    @Override
    protected void action() {
        controller.updatePatientStatus();
        previousMenu.act();
    }
}
