package model;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person {
    private final String emergencyContact;
    private List<String> allergies;
    private List<String> specialCares;
    private String insurance;
    private Integer insuranceNumber;
    private LocalDate insuranceExpiryDate;
    private Status status;
    private Integer numberOfTreatmentsPerformed = 0;
    public Patient(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone, String emergencyContact) {
        super(fullName, gender, birthday, cpf, telephone);
        this.emergencyContact = emergencyContact;
    }

    public String getInsurance() {
        return insurance;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getNumberOfTreatmentsPerformed() {
        return numberOfTreatmentsPerformed;
    }
}
