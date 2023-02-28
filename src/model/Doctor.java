package model;

import java.time.LocalDate;

public class Doctor extends Worker {
    private final Specialization specialization;
    private Boolean active;
    private Integer numberOfTreatmentsPerformed = 0;
    public Doctor(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone, String schoolAttended, String councilId, Specialization specialization) {
        super(fullName, gender, birthday, cpf, telephone, schoolAttended, councilId);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
