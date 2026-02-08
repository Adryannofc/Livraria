import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Biblioteca biblioteca = BibliotecaStorage.carregar();

    public static void main(String[] args) {
        while (true) {
            telaMenu();

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerenciarLivros();
                    break;
                case 2:
                    gerenciarUsuarios();
                    break;
                case 3:
                    System.out.println("Empréstimos (Em breve)...");
                    pause();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    BibliotecaStorage.salvar(biblioteca);
                    return;
                default:
                    System.out.println("Opção Inválida!");
                    pause();
            }
            limparTela();
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
        listarLivros();
        System.out.println("[1] Cadastrar Novo Livro");
        System.out.println("[2] Remover Livro");
        System.out.println("[3] Buscar por Título");
        System.out.println("[0] Voltar\n");
        System.out.print("- Opcão: ");
    }

    static void cadastrarLivro() {
        limparTela(); // Começa com a tela limpa
        System.out.println("===========================================================");
        System.out.println("            📚️  CADASTRO DE NOVO LIVRO                     ");
        System.out.println("===========================================================");

        System.out.print("Titulo: ");
        String titulo = scan.nextLine();


        System.out.print("Autor: ");
        String autor = scan.nextLine();

        int novoId = biblioteca.getLivros().size() + 1;
        Livro novoLivro = new Livro(novoId, titulo, autor);
        biblioteca.cadastrarLivro(novoLivro);
        BibliotecaStorage.salvar(biblioteca);
        System.out.println("===========================================================");
        System.out.println(" ✅ Livro cadastrado com sucesso! ID gerado: " + novoId);
    }

    static void gerenciarLivros() {
        while (true) {
            telaLivros();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
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

    static void listarLivros() {
        System.out.printf(" %-5s | %-20s | %-16s | %s %n", "ID", "TITULO", "AUTOR", "STATUS");
        System.out.println("-------|----------------------|------------------|---------");

        if (biblioteca.getLivros().isEmpty()) {
            System.out.println("   (Nenhum livro cadastrado)");
        } else {
            for (Livro l : biblioteca.getLivros()) {
                System.out.printf(" [%03d] | %-20s | %-16s | %s %n" +
                                "",
                        l.getId(),
                        l.getTitulo(),
                        l.getAutor(),
                        l.getStatusLivro());
            }
        }
        System.out.println("=============================================================");
    }

    static void telaUsuarios() {
        limparTela();
        System.out.println("|===========================================================|");
        System.out.println("|                📚️   GERENCIAR USUARIOS                    |");
        System.out.println("|===========================================================|");
        listarUsuarios();
        System.out.println("-------------------------------------------------------------");
        System.out.println("[1] Cadastrar");
        System.out.println("[2] Remover");
        System.out.println("[3] Buscar");
        System.out.println("[0] Voltar\n");
        System.out.print("- Opcão: ");
    }

    static void cadastrarUsuario() {
        limparTela(); // Começa com a tela limpa
        System.out.println("===========================================================");
        System.out.println("            📝  CADASTRO DE NOVO LEITOR                    ");
        System.out.println("===========================================================");

        System.out.print("Nome Completo: ");
        String nome = scan.nextLine();

        int novoId = biblioteca.getUsuarios().size() + 1;

        Usuario novoUsuario = new Usuario(novoId, nome);

        biblioteca.cadastrarUsuario(novoUsuario);
        BibliotecaStorage.salvar(biblioteca);

        System.out.println("===========================================================");
        System.out.println(" ✅ Usuário cadastrado com sucesso! ID gerado: " + novoId);

        pause();
    }

    static void gerenciarUsuarios() {
        while (true) {
            telaUsuarios();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    pause();
                    break;
                case 3:
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

    static void listarUsuarios() {
        System.out.printf(" %-5s | %-24s | %-6s | %s %n", "ID", "NOME", "LIVROS", "STATUS");
        System.out.println("-------|--------------------------|--------|----------------");

        if (biblioteca.getUsuarios().isEmpty()) {
            System.out.println("   (Nenhum usuário cadastrado)");
        } else {
            for (Usuario u : biblioteca.getUsuarios()) {
                System.out.printf(" [%03d] | %-24s |   %-4d | %s %n",
                        u.getId(),
                        u.getNome(),
                        u.getLivrosComEle(),
                        u.getStatusUsuario()
                );
            }
        }
        System.out.println("===============================================================");
    }

    static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static void pause() {
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
