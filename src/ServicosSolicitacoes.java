import java.util.ArrayList;
import java.util.List;

public class ServicosSolicitacoes {

    private List<Solicitacoes> solicitacoes = new ArrayList<>();

    public void criarSolicitacao( Solicitacoes solicitacao ) {
        solicitacoes.add( solicitacao );
    }

    public void listarTodas() {

        if ( solicitacoes.isEmpty() ) {
            System.out.println( "Nenhuma solicitação cadastrada." );
            return;
        }

        for ( Solicitacoes soli : solicitacoes ) {
            exibirResumo( soli );
        }
    }

    public void listarPorEstado( String estado ) {

        boolean encontrou = false;

        for ( Solicitacoes soli : solicitacoes ) {
            if ( soli.getEstado().equalsIgnoreCase( estado ) ) {
                exibirResumo( soli );
                encontrou = true;
            }
        }

        if ( !encontrou ) {
            System.out.println( "Nenhuma solicitação encontrada para o estado." );
        }
    }

    public Solicitacoes buscarPorProtocolo( String protocolo ) {
        for ( Solicitacoes soli : solicitacoes) {
            if ( soli.getProtocolo().equalsIgnoreCase( protocolo ) ) {
                return soli;
            }
        }
        return null;
    }

    public void atualizarStatus( String protocolo, Status novoStatus, String comentario ) {

        if (comentario == null || comentario.isEmpty()) {
            System.out.println("Comentário obrigatório!");
            return;
        }

        Solicitacoes soli = buscarPorProtocolo( protocolo );

        if ( soli != null ) {
            soli.atualizarStatus(novoStatus, comentario);
            System.out.println( "Status atualizado com sucesso!" );
        } else {
            System.out.println( "Solicitação não encontrada."  );
        }
    }

    public void listarPorUsuario( Usuario usuario ) {

        boolean encontrou = false;

        for ( Solicitacoes soli : solicitacoes ) {
            if ( soli.getUsuario().getCpf().equals(usuario.getCpf() ) ) {

                System.out.println( "----------------------------" );
                System.out.println( "Protocolo: " + soli.getProtocolo() );
                System.out.println( "Nome: " + soli.getUsuario().getNome() );
                System.out.println( "Estado: " + soli.getEstado() );
                System.out.println( "Cidade: " + soli.getCidade() );
                System.out.println( "Categoria: " + soli.getCategoria() );
                System.out.println( "Descrição: " + soli.getDescricao() );
                System.out.println( "Data: " + soli.getDataAbertura() );
                System.out.println( "Status: " + soli.getStatusAtual() );

                encontrou = true;
            }
        }

        if ( !encontrou ) {
            System.out.println( "Nenhuma solicitação encontrada para este usuário." );
        }
    }

    public void mostrarFila() {

        int posicao = 1;
        boolean encontrou = false;

        for ( Solicitacoes soli : solicitacoes ) {

            if ( soli.getStatusAtual() == Status.ANALISE || soli.getStatusAtual() == Status.TRIAGEM ) {

                String nome = soli.getUsuario().getNome();

                if ( nome != null && nome.contains(" ") ) {
                    nome = nome.split(" ")[0];
                }

                System.out.println( "----------------------------" );
                System.out.println( "Protocolo: " + soli.getProtocolo() );
                System.out.println( "Data: " + soli.getDataAbertura() );
                System.out.println( "Nome: " + nome );
                System.out.println( "Posição: " + posicao );

                posicao++;
                encontrou = true;
            }
        }

        if ( !encontrou ) {
            System.out.println("Nenhuma solicitação em fila.");
        }
    }

    public void quantidadePorEstado() {

        if ( solicitacoes.isEmpty() ) {
            System.out.println("Nenhuma solicitação cadastrada.");
            return;
        }

        List<String> estadosContados = new ArrayList<>();

        for ( Solicitacoes soli : solicitacoes ) {

            String estado = soli.getEstado();

            if ( !estadosContados.contains( estado ) ) {

                int count = 0;

                for ( Solicitacoes soli02 : solicitacoes ) {
                    if ( soli02.getEstado().equalsIgnoreCase(estado)) {
                        count++;
                    }
                }

                System.out.println(estado + " - " + count + " solicitações");

                estadosContados.add(estado);
            }
        }
    }

    private void exibirResumo( Solicitacoes soli ) {
        System.out.println( "----------------------------" );
        System.out.println( "Protocolo: " + soli.getProtocolo() );
        System.out.println( "Estado: " + soli.getEstado() );
        System.out.println( "Cidade: " + soli.getCidade() );
        System.out.println( "Status: " + soli.getStatusAtual() );
        System.out.println( "Data: " + soli.getDataAbertura() );
        System.out.println( "Aberto por: " + soli.getUsuario().getNome() );
    }

    public List<Solicitacoes> getSolicitacoes() {
        return solicitacoes;
    }

    public void listarPorPrioridade() {

        if (solicitacoes.isEmpty()) {
            System.out.println("Nenhuma solicitação cadastrada.");
            return;
        }

        for (Solicitacoes soli : solicitacoes) {
            if (soli.getRiscoVida()) {
                exibirDetalhado(soli);
            }
        }

        for (Solicitacoes soli : solicitacoes) {
            if (!soli.getRiscoVida()) {
                exibirDetalhado(soli);
            }
        }
    }

    private void exibirDetalhado(Solicitacoes soli) {
        System.out.println("----------------------------");
        System.out.println("Protocolo: " + soli.getProtocolo());
        System.out.println("Nome: " + soli.getUsuario().getNome());
        System.out.println("Prioridade: " + (soli.getRiscoVida() ? "ALTA" : "NORMAL"));
        System.out.println("Risco de vida: " + (soli.getRiscoVida() ? "SIM" : "NÃO"));
        System.out.println("Descrição: " + soli.getDescricao());
        System.out.println("Data: " + soli.getDataAbertura());
    }
}