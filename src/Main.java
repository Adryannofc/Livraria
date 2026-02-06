import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        while (true) {
            telaMenu();
            Scanner scan = new Scanner(System.in);
            int opcao;

            try {
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("❌ ERRO: Digite apenas números!");
                scan.nextLine();
                continue;
            }
        }


    }

    static void telaMenu() {
        System.out.println("|===========================================================|");
        System.out.println("|          🏛️   SISTEMA BIBLIOTECA ROCKEATSEAT              |");
        System.out.println("|===========================================================|");

        System.out.println("[1] \uD83D\uDCDA GERENCIAR LIVROS");
        System.out.println("[2] \uD83D\uDC65 GERENCIAR USUARIOS");
        System.out.println("[3] \uD83D\uDD04 REAKUZAR EMPRESTIMO / DEVOLUCÃO");
        System.out.println("[4] \uD83D\uDCCA RELATORIOS");
        System.out.println("[0] ❌ SAIR");
    }

    static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}