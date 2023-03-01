package controller;

import model.Gender;
import model.Person;
import model.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerHelper {
    private final static Scanner scanner = new Scanner(System.in);

    public static Person getPersonData() {
        String fullName = getString("o nome completo");
        Gender gender = getGender();
        LocalDate birthday = getBirthday();
        String cpf = getString("o CPF");
        String telephone = getString("o telefone");
        return new Person(fullName, gender, birthday, cpf, telephone);
    }

    public static String getString(String field) {
        String string = "";

        while (string.equals("")) {
            System.out.print("Informar %s: ".formatted(field));
            string = scanner.nextLine();
        }
        return string;
    }

    private static Gender getGender() {
        Gender gender = null;
        while (gender == null) {
            try {
                gender = Gender.valueOf(getString("o gênero (masculino, feminino, outro)").toLowerCase());
            } catch (Exception e) {
                System.out.println("Gênero inválido.");
            }
        }
        return gender;
    }

    private static LocalDate getBirthday() {
        LocalDate birthday = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (birthday.equals(LocalDate.now()) || birthday.isAfter(LocalDate.now())) {
            try {
                String birthdayAsString = getString("a data de nascimento (DD/MM/AAAA)");
                birthday = LocalDate.parse(birthdayAsString, formatter);
                if (birthday.isAfter(LocalDate.now()))
                    System.out.println("Data de nascimento inválida.");
            } catch (Exception e) {
                System.out.println("Data de nascimento inválida.");
            }
        }
        return birthday;
    }

    public static String getSpecialization() {
        String[] specializations = {
                "Clínico Geral",
                "Anestesista",
                "Dermatologista",
                "Ginecologista",
                "Neurologista",
                "Pediatra",
                "Psiquiatra",
                "Ortopedista"
        };

        String specialization = null;

        while (specialization == null) {
            try {
                System.out.println("Informe a especialização: ");
                for (int i = 1; i <= specializations.length; i++)
                    System.out.println("%d. %s".formatted(i, specializations[i - 1]));
                int option = scanner.nextInt();
                scanner.nextLine();
                specialization = specializations[option - 1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido.");
            } catch (Exception e) {
                System.out.println("Digite apenas um número.");
                scanner.nextLine();
            }
        }
        
        return specialization;
    }

    public static Boolean getBoolean(String string) {
        Boolean active = null;
        while (active == null ) {
            String activeString = getString(string);
            if (activeString.toLowerCase().charAt(0) == 's')
                active = true;
            else if (activeString.toLowerCase().charAt(0) == 'n')
                active = false;
            else System.out.println("Digite S ou N.");
        }
        return active;
    }

    public static Status getStatus() {
        int option = 0;
        Status status = null;

        while (option < 1 || option > Status.values().length) {
            try {
                System.out.println("Informe o status do paciente: ");
                for (int i = 1; i <= Status.values().length; i++)
                    System.out.println("%d. %s".formatted(i, Status.values()[i - 1].getStatus()));
                option = scanner.nextInt();
                scanner.nextLine();
                status = Status.values()[option - 1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido.");
            } catch (Exception e) {
                System.out.println("Digite apenas um número.");
                scanner.nextLine();
            }
        }

        return status;
    }

    public static Boolean hasAllergies() {
        return getBoolean("se tem alergias (S/N)");
    }

    public static List<String> getList(String string) {
        List<String> list = new ArrayList<>();
        list.add(getString("o primeiro item da lista de %s".formatted(string)));

        while(getBoolean("se deseja acrescentar mais um item na lista (S/N)"))
            list.add(getString("o próximo item da lista de %s".formatted(string)));

        return list;
    }

    public static boolean hasSpecialNeeds() {
        return getBoolean("se tem necessidades especiais (S/N)");
    }

    public static boolean hasInsurance() {
        return getBoolean("se tem convênio médico (S/N)");
    }

    public static Integer getId(String string) {
        int id = -1;
        while (id < 0 || id >= Person.getNextId()) {
            System.out.print(string);
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0 || id >= Person.getNextId())
                    System.out.println("Código não existente.");
            } catch (Exception e) {
                System.out.println("Digite um número.");
                scanner.nextLine();
            }
        }

        return id;
    }

    public static LocalDate getExpiryDate() {
        LocalDate expiryDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (expiryDate.equals(LocalDate.now()) || expiryDate.isBefore(LocalDate.now())) {
            try {
                String expiryDateAsString = getString("a data de vencimento do convênio (DD/MM/AAAA)");
                expiryDate = LocalDate.parse(expiryDateAsString, formatter);
                if (expiryDate.isAfter(LocalDate.now()))
                    System.out.println("Data de vencimento inválida.");
            } catch (Exception e) {
                System.out.println("Data de vencimento inválida.");
            }
        }
        return expiryDate;
    }

    public static Boolean wantsByStatus() {
        return getBoolean(("se deseja informação por status (S) ou de todos os pacientes (N)"));
    }

    public static Boolean wantsSpecialization() {
        return getBoolean("se deseja informação por especialização (S) ou de todos os médicos (N)");
    }


}
