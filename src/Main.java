public class Main {
    public static void main(String[] args) {

        Usuario usuario01 = new Usuario("Felipe M.", "felipematrone@gmail.com", "44991024053", "11553125353", false );

        System.out.println("------ TESTE USUARIO REGISTRADO ------");
        System.out.println("Nome: " + usuario01.getNome());
        System.out.println("Email: " + usuario01.getEmail());
        System.out.println("Telefone: " + usuario01.getTelefone());
        System.out.println("CPF: " + usuario01.getCpf());
        System.out.println("Registrado: " + usuario01.getRegistrado());

        Solicitacoes solicitacao = new Solicitacoes( usuario01, "PR", "Maringá", "Buraco grande na rua", "Infraestrutura", true );

        System.out.println("\n------ TESTE SOLICITAÇÃO ------");
        System.out.println("Protocolo: " + solicitacao.getProtocolo());
        System.out.println("Estado: " + solicitacao.getEstado());
        System.out.println("Cidade: " + solicitacao.getCidade());
        System.out.println("Status atual: " + solicitacao.getStatusAtual());
        System.out.println("Data abertura: " + solicitacao.getDataAbertura());
        System.out.println("Risco de vida: " + solicitacao.getRiscoVida());


    }
}