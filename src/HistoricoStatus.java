import java.time.LocalDateTime;

public class HistoricoStatus {

    private Status status;
    private LocalDateTime data;
    private String descricao;

public HistoricoStatus( Status status, String descricao ) {
    this.status = status;
    this.data = LocalDateTime.now();
    this.descricao = descricao;
  }

    public Status getStatus() {
        return status;
    }

    public void setStatus( Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

}
