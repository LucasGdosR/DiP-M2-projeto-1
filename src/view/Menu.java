package view;

public abstract class Menu {
    private final String description;
    protected final Menu previousMenu;

    public Menu(String description, Menu previousMenu) {
        this.description = description;
        this.previousMenu = previousMenu;
    }

    public final void show() {
        System.out.println(description);
    }

    public final void act() {
        showWithSeparator();
        action();
    }

    protected abstract void action();

    private void showWithSeparator() {
        showSeparator();
        show();
        showSeparator();
    }

    private void showSeparator() {
        System.out.println("-------------------------------------------");
    }
}