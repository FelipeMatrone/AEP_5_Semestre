import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ServicosSolicitacoes servico = new ServicosSolicitacoes();
    static ServicosUsuario servicoUsuarios = new ServicosUsuario();

    public static void main(String[] args) {

        while (true) {
            menuInicial();
        }
    }

    public static void menuInicial() {

        System.out.println("\n===== SISTEMA =====");
        System.out.println("1) - Login");
        System.out.println("2) - Registrar");
        System.out.println("3) - Entrar sem cadastro");
        System.out.println("4) - Sair");

        int op;
        try {
            op = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            return;
        }

        switch (op) {
            case 1:
                realizarLogin();
                break;
            case 2:
                registrarUsuario();
                break;
            case 3:
                entrarSemCadastro();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public static void realizarLogin() {

        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();

        Usuario usuario = servicoUsuarios.login(cpf);

        if (usuario != null) {
            System.out.println("Login realizado!");

            if (usuario.getTipo() == TipoUsuario.ANALISTA) {
                MenuAnalista.menu(usuario, servico, sc);
            } else {
                menuUsuario(usuario);
            }

        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void registrarUsuario() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();

        System.out.println("Tipo (1 - Cidadão | 2 - Analista): ");
        int tipoOp = Integer.parseInt(sc.nextLine());
        TipoUsuario tipo = (tipoOp == 2) ? TipoUsuario.ANALISTA : TipoUsuario.CIDADAO;

        Usuario novo = new Usuario(nome, email, tel, cpf);
        servicoUsuarios.registrar(novo);
        novo.setTipo(tipo);

        System.out.println("Registrado com sucesso!");
    }

    public static void entrarSemCadastro() {

        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();

        Usuario usuario = new Usuario(cpf);
        usuario.setTipo(TipoUsuario.CIDADAO);

        menuUsuario(usuario);
    }

    public static void menuUsuario(Usuario usuario) {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1) - Novo chamado");
            System.out.println("2) - Meus chamados");
            System.out.println("3) - Ver fila");
            System.out.println("4) - Quantidade por estado");
            System.out.println("5) - Sair");

            int op;
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (op) {
                case 1:
                    criarChamado(usuario);
                    break;

                case 2:
                    servico.listarPorUsuario(usuario);
                    break;

                case 3:
                    servico.mostrarFila();
                    break;

                case 4:
                    servico.quantidadePorEstado();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void criarChamado(Usuario usuario) {

        System.out.print("Estado (sigla): ");
        String estado = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        System.out.print("Risco de vida (sim/nao): ");
        String riscoStr = sc.nextLine().toLowerCase();
        boolean risco = riscoStr.equals("sim");

        Solicitacoes s = new Solicitacoes(
                usuario,
                estado,
                cidade,
                descricao,
                categoria,
                risco
        );

        servico.criarSolicitacao(s);

        System.out.println("Chamado criado! Protocolo: " + s.getProtocolo());
    }
}