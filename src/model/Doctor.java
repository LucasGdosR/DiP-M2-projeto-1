package model;

import java.time.LocalDate;

public class Doctor extends Worker {
    private final String specialization;
    private final Boolean active;
    private Integer numberOfTreatmentsPerformed = 0;
    public Doctor(String fullName,
                  Gender gender,
                  LocalDate birthday,
                  String cpf,
                  String telephone,
                  String schoolAttended,
                  String councilId,
                  String specialization,
                  Boolean active) {
        super(fullName, gender, birthday, cpf, telephone, schoolAttended, councilId);
        this.specialization = specialization;
        this.active = active;
        super.id = Person.nextId++;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String fullToString() {
        return "Id: %d; Nome: %s; Instituição de Ensino: %s; CRM: %s; Especialização: %s"
                .formatted(id, getFullName(), getSchoolAttended(), getCouncilId(), getSpecialization());
    }

    public Integer getNumberOfTreatmentsPerformed() {
        return numberOfTreatmentsPerformed;
    }

    public void performTreatment() {
        this.numberOfTreatmentsPerformed++;
    }
}
