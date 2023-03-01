import controller.Controller;
import model.Doctor;
import model.Nurse;
import model.Patient;
import repository.PersonRepository;
import view.Menu;
import view.implementations.factory.MainMenuFactory;

public class Main {
    public static void main(String[] args) {
        PersonRepository<Doctor> doctorRepository = new PersonRepository<>();
        PersonRepository<Nurse> nurseRepository = new PersonRepository<>();
        PersonRepository<Patient> patientRepository = new PersonRepository<>();
        Controller controller = new Controller(doctorRepository, nurseRepository, patientRepository);
        MainMenuFactory factory = new MainMenuFactory();
        Menu menu = factory.create(controller);
        System.out.println("Bem vindo ao Lab Medicine!");
        menu.act();
    }
}