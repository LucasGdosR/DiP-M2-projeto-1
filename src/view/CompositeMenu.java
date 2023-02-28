package view;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeMenu extends Menu {
    private final List<Menu> submenus = new ArrayList<>();

    public CompositeMenu(String description, Menu previousMenu) {
        super(description, previousMenu);
    }

    @Override
    protected void action() {
        showSubmenus();
        Menu menu = selectSubmenu();
        menu.act();
    }

    private void showSubmenus() {
        for (int i = 1; i < submenus.size(); i++) {
            System.out.printf("%s. ", i);
            Menu menu = submenus.get(i);
            menu.show();
        }

        System.out.print("0. ");
        Menu menu = submenus.get(0);
        menu.show();
    }

    private Menu selectSubmenu() {
        Integer selectedOption = InputHelper.inputOption("menu");
        return submenus.get(selectedOption);
    }

    public void addSubmenu(Menu menu) {
        submenus.add(menu);
    }
}
