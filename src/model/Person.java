package model;

import java.time.LocalDate;

public class Person {
    protected static int nextId = 0;
    protected int id;
    private final String fullName;
    private final Gender gender;
    private final LocalDate birthday;
    private final String cpf;
    private final String telephone;

    public Person(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone) {
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

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public String basicToString() {
        return "Id: %d; CPF: %s; Nome: %s.".formatted(this.id, this.cpf, this.fullName);
    }

    public static Integer getNextId() {
        return nextId;
    }
}
