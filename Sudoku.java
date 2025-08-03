import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean[][] fixed = new boolean[SIZE][SIZE];

    private static boolean jogoIniciado = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carregarTabuleiroInicial();

        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> iniciarJogo();
                case 2 -> colocarNumero(scanner);
                case 3 -> removerNumero(scanner);
                case 4 -> mostrarTabuleiro();
                case 5 -> verificarStatusJogo();
                case 6 -> limparTabuleiro();
                case 7 -> finalizarJogo();
                case 0 -> System.out.println("Encerrando o jogo.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // ✅ Menu interativo
    private static void mostrarMenu() {
        System.out.println("\n📋 MENU SUDOKU:");
        System.out.println("1. Iniciar novo jogo");
        System.out.println("2. Colocar número");
        System.out.println("3. Remover número");
        System.out.println("4. Verificar jogo");
        System.out.println("5. Verificar status do jogo");
        System.out.println("6. Limpar (remover números inseridos)");
        System.out.println("7. Finalizar jogo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // ✅ Exemplo de preenchimento inicial
    private static void carregarTabuleiroInicial() {
        // Exemplo de valores fixos com base na imagem
        int[][] inicial = {
            {9, 5, 8, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 2, 5, 6, 0, 4, 0},
            {0, 6, 0, 0, 0, 0, 5, 1, 7},
            {6, 0, 0, 3, 7, 8, 0, 0, 0},
            {7, 8, 4, 0, 0, 0, 9, 3, 2},
            {0, 0, 0, 4, 2, 9, 0, 0, 8},
            {4, 9, 2, 0, 0, 0, 0, 0, 1},
            {0, 6, 0, 5, 8, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 7, 6, 3},
        };

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = inicial[i][j];
                fixed[i][j] = inicial[i][j] != 0;
            }
        }
    }

    // ✅ Começar o jogo
    private static void iniciarJogo() {
        jogoIniciado = true;
        System.out.println("Novo jogo iniciado!");
        mostrarTabuleiro();
    }

    // ✅ Inserir número
    private static void colocarNumero(Scanner sc) {
        if (!jogoIniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }

        System.out.print("Informe o número (1 a 9): ");
        int num = sc.nextInt();
        System.out.print("Informe a linha (0 a 8): ");
        int lin = sc.nextInt();
        System.out.print("Informe a coluna (0 a 8): ");
        int col = sc.nextInt();

        if (num < 1 || num > 9 || lin < 0 || lin > 8 || col < 0 || col > 8) {
            System.out.println("Entrada inválida.");
            return;
        }

        if (fixed[lin][col]) {
            System.out.println("❌ Não é possível sobrescrever um número fixo.");
        } else if (board[lin][col] != 0) {
            System.out.println("❌ Já existe um número nessa posição.");
        } else {
            board[lin][col] = num;
            System.out.println("✅ Número inserido!");
        }
    }

    // ✅ Remover número
    private static void removerNumero(Scanner sc) {
        if (!jogoIniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }

        System.out.print("Informe a linha (0 a 8): ");
        int lin = sc.nextInt();
        System.out.print("Informe a coluna (0 a 8): ");
        int col = sc.nextInt();

        if (fixed[lin][col]) {
            System.out.println("❌ Não é possível remover um número fixo.");
        } else {
            board[lin][col] = 0;
            System.out.println("✅ Número removido!");
        }
    }

    // ✅ Exibir tabuleiro
    private static void mostrarTabuleiro() {
        System.out.println("\n🧩 SITUAÇÃO DO TABULEIRO:");
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // ✅ Verificar se o jogo está completo e se tem erro
    private static void verificarStatusJogo() {
        if (!jogoIniciado) {
            System.out.println("🔴 Status: Não iniciado (sem erros)");
            return;
        }

        boolean completo = true;
        boolean erro = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) completo = false;
                if (!valido(i, j)) erro = true;
            }
        }

        if (completo && !erro) {
            System.out.println("✅ Status: Completo e sem erros");
        } else if (completo) {
            System.out.println("⚠️ Status: Completo mas com ERROS");
        } else if (!erro) {
            System.out.println("🟡 Status: Incompleto e sem erros");
        } else {
            System.out.println("🔴 Status: Incompleto e com ERROS");
        }
    }

    // ✅ Verificar regras do Sudoku
    private static boolean valido(int lin, int col) {
        int num = board[lin][col];
        if (num == 0) return true;

        for (int i = 0; i < SIZE; i++) {
            if (i != lin && board[i][col] == num) return false;
            if (i != col && board[lin][i] == num) return false;
        }

        int boxRow = (lin / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if ((i != lin || j != col) && board[i][j] == num) return false;
            }
        }

        return true;
    }

    // ✅ Limpar tabuleiro do usuário
    private static void limparTabuleiro() {
        if (!jogoIniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!fixed[i][j]) {
                    board[i][j] = 0;
                }
            }
        }

        System.out.println("Todos os números inseridos foram removidos.");
    }

    // ✅ Encerrar jogo
    private static void finalizarJogo() {
        boolean completo = true;
        boolean erro = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) completo = false;
                if (!valido(i, j)) erro = true;
            }
        }

        if (completo && !erro) {
            System.out.println("🎉 Parabéns! Jogo finalizado com sucesso!");
            mostrarTabuleiro();
            System.exit(0);
        } else {
            System.out.println("❌ O jogo ainda contém espaços vazios ou erros.");
        }
    }
}
