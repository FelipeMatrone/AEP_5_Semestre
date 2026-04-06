import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Solicitacoes {

    private static int contador = 1;
    private String protocolo;
    private Usuario usuario;
    private String estado;
    private String cidade;
    private String descricao;
    private boolean riscoVida;

    private Status statusAtual;
    private LocalDateTime dataAbertura;

    private List<HistoricoStatus> historico;

    public Solicitacoes( Usuario usuario, String estado, String cidade, String descricao, boolean riscoVida ) {

        this.protocolo = estado.toUpperCase() + String.format("%06d", contador++);
        this.usuario   = usuario;
        this.estado    = estado;
        this.cidade    = cidade;
        this.descricao = descricao;
        this.riscoVida = riscoVida;
        this.statusAtual = Status.ANALISE;
        this.dataAbertura = LocalDateTime.now();
        this.historico = new ArrayList<>();

        historico.add( new HistoricoStatus( Status.ANALISE, "Solicitação criada com sucesso!" ) );
    }

    public String getProtocolo() {
        return protocolo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getRiscoVida() {
        return riscoVida;
    }

    public void setRiscoVida( boolean riscoVida ) {
        this.riscoVida = riscoVida;
    }

    public Status getStatusAtual() {
        return statusAtual;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public List<HistoricoStatus> getHistorico() {
        return historico;
    }

    public void atualizarStatus( Status novoStatus, String comentario ) {
        this.statusAtual = novoStatus;
        historico.add(new HistoricoStatus(novoStatus, comentario ) );
    }
}