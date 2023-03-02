package model;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person {
    private final String emergencyContact;
    private List<String> allergies;
    private List<String> specialCares;
    private String insurance;
    private String insuranceNumber;
    private LocalDate insuranceExpiryDate;
    private Status status;
    private Integer numberOfTreatmentsReceived = 0;
    public Patient(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone, String emergencyContact, Status status) {
        super(fullName, gender, birthday, cpf, telephone);
        this.emergencyContact = emergencyContact;
        this.status = status;
        super.id = Person.nextId++;
    }

    public String getInsurance() {
        return insurance;
    }

    public Status getStatus() {
        return status;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public void setSpecialCares(List<String> specialCares) {
        this.specialCares = specialCares;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void receiveTreatment() {
        this.numberOfTreatmentsReceived++;
        setStatus(Status.TREATMENT_IN_PROGRESS);
    }

    public String fullToString() {
        return "Id: %d; Nome: %s; Convênio: %s; Total de atendimentos: %d"
                .formatted(id, getFullName(), insurance == null ? "Sem Convênio" : insurance, numberOfTreatmentsReceived);
    }
}
