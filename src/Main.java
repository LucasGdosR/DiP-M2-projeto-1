import controller.Controller;
import view.Menu;
import view.implementations.factory.MainMenuFactory;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainMenuFactory factory = new MainMenuFactory();
        Menu menu = factory.create(controller);
        System.out.println("Bem vindo ao Lab Medicine!");
        menu.act();
    }
}