package model;

import java.time.LocalDate;

public abstract class Person {
    private static int nextId = 0;
    private final int id;
    private final String fullName;
    private final Gender gender;
    private final LocalDate birthday;
    private final String cpf;
    private final String telephone;

    public Person(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone) {
        this.id = nextId++;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.cpf = cpf;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpf() {
        return cpf;
    }
}
