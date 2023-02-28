package model;

public enum Status {
    AWAITING_TREATMENT("Aguardando Atendimnento"),
    TREATMENT_IN_PROGRESS("Em Atendimento"),
    TREATMENT_FINISHED("Atendido"),
    UNTREATED("Não Atendido");

    Status(String status) {
    }
}
