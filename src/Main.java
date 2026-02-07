import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            telaMenu();

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerenciarLivros();
                    break;
                case 2:
                    System.out.println("Gerenciar Usuários (Em breve)...");
                    pause();
                    break;
                case 3:
                    System.out.println("Empréstimos (Em breve)...");
                    pause();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção Inválida!");
                    pause();
            }
            limparTela();
        }
    }


    static void gerenciarLivros() {
        while (true) {
            telaLivros();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    System.out.println(">> Cadastrando livro...");
                    pause();
                    break;
                case 2:
                    System.out.println(">> Removendo livro...");
                    pause();
                    break;
                case 3:
                    System.out.println(">> Buscando...");
                    pause();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção Inválida!");
                    pause();
            }
        }
    }

    static void telaMenu() {

        System.out.println("|===========================================================|");
        System.out.println("|          🏛️   SISTEMA BIBLIOTECA ROCKETSEAT               |");
        System.out.println("|===========================================================|");
        System.out.println("[1] \uD83D\uDCDA GERENCIAR LIVROS");
        System.out.println("[2] \uD83D\uDC65 GERENCIAR USUARIOS");
        System.out.println("[3] \uD83D\uDD04 REALIZAR EMPRESTIMO / DEVOLUCÃO");
        System.out.println("[4] \uD83D\uDCCA RELATORIOS");
        System.out.println("[0] ❌ SAIR\n");
        System.out.print("- Opcão: ");
    }

    static void telaLivros() {
        limparTela();
        System.out.println("|===========================================================|");
        System.out.println("|                📚️   GERENCIAR LIVROS                      |");
        System.out.println("|===========================================================|");
        System.out.println("ID  | TÍTULO                | AUTOR          | STATUS");
        System.out.println("----|-----------------------|----------------|-------------");
        System.out.println("[1] | Dom Casmurro          | M. de Assis    | ✅ Disponível");
        System.out.println("[2] | O Código Da Vinci     | Dan Brown      | 🔴 Emprestado");
        System.out.println("-------------------------------------------------------------");
        System.out.println("[1] Cadastrar Novo Livro");
        System.out.println("[2] Remover Livro");
        System.out.println("[3] Buscar por Título");
        System.out.println("[0] Voltar\n");
        System.out.print("- Opcão: ");
    }

    static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static void pause(){
        System.out.print("Pressione ENTER para continuar...");
        scan.nextLine(); // Usa o Scanner GLOBAL
    }

    static int lerOpcao() {
        try {
            int opcao = scan.nextInt();
            scan.nextLine();
            return opcao;
        } catch (Exception e) {
            scan.nextLine();
            return -1;
        }
    }
}