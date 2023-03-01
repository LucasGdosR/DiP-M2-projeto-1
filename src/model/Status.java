package model;

public enum Status {
    AWAITING_TREATMENT("Aguardando Atendimento"),
    TREATMENT_IN_PROGRESS("Em Atendimento"),
    TREATMENT_FINISHED("Atendido"),
    UNTREATED("Não Atendido");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
