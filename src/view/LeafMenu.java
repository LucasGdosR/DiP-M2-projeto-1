package view;

import controller.Controller;

public abstract class LeafMenu extends Menu {
    protected Controller controller;

    public LeafMenu(String description, Menu previousMenu, Controller controller) {
        super(description, previousMenu);
        this.controller = controller;
    }
}
