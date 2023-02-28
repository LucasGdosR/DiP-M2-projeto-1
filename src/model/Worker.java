package model;

import java.time.LocalDate;

public abstract class Worker extends Person {
    private final String schoolAttended;
    private final String councilId;

    public Worker(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone, String schoolAttended, String councilId) {
        super(fullName, gender, birthday, cpf, telephone);
        this.schoolAttended = schoolAttended;
        this.councilId = councilId;
    }

    public String getSchoolAttended() {
        return schoolAttended;
    }

    public String getCouncilId() {
        return councilId;
    }
}
