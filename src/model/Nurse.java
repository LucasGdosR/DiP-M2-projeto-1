package model;

import java.time.LocalDate;

public class Nurse extends Worker {
    public Nurse(String fullName, Gender gender, LocalDate birthday, String cpf, String telephone, String schoolAttended, String councilId) {
        super(fullName, gender, birthday, cpf, telephone, schoolAttended, councilId);
    }
}
