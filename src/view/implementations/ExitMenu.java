package view.implementations;

import view.LeafMenu;
import view.Menu;

public class ExitMenu extends LeafMenu {
    public ExitMenu(Menu previousMenu) {
        super("Sair", previousMenu, null);
    }

    @Override
    protected void action() {
        System.out.println("Encerrando...");
        System.exit(0);
    }
}
