import java.util.Scanner;

public class MenuAnalista {

    public static void menu(Usuario usuario, ServicosSolicitacoes servico, Scanner sc) {

        while (true) {

            System.out.println("\n===== MENU ANALISTA =====");
            System.out.println("1) - Listar chamados (prioridade)");
            System.out.println("2) - Atualizar status");
            System.out.println("3) - Quantidade por estado");
            System.out.println("4) - Ver fila");
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
                    listarPrioridade(servico);
                    break;

                case 2:
                    atualizarStatus(servico, sc);
                    break;

                case 3:
                    servico.quantidadePorEstado();
                    break;

                case 4:
                    servico.mostrarFila();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void listarPrioridade(ServicosSolicitacoes servico) {
        servico.listarPorPrioridade();
    }

    private static void atualizarStatus(ServicosSolicitacoes servico, Scanner sc) {

        System.out.print("Protocolo: ");
        String protocolo = sc.nextLine();

        System.out.print("Novo status: ");
        String statusStr = sc.nextLine().toUpperCase();

        System.out.print("Comentário: ");
        String comentario = sc.nextLine();

        if (comentario == null || comentario.isEmpty()) {
            System.out.println("Comentário obrigatório!");
            return;
        }

        try {
            Status novoStatus = Status.valueOf(statusStr);
            servico.atualizarStatus(protocolo, novoStatus, comentario);
        } catch (IllegalArgumentException e) {
            System.out.println("Status inválido!");
        }
    }
}