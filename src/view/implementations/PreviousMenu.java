package view.implementations;

import view.LeafMenu;
import view.Menu;

public class PreviousMenu extends LeafMenu {

    public PreviousMenu(Menu previousMenu) {
        super("Voltar ao menu anterior", previousMenu, null);
    }

    @Override
    protected void action() {
        previousMenu.act();
    }
}
