import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    // 建立並初始化 5x5 棋盤
    public static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    // 列印棋盤，含行列索引
    public static void printBoard(char[][] board) {
        System.out.println();
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 放置棋子，成功回傳 true
    public static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    // 檢查是否有玩家獲勝
    public static char checkWinner(char[][] board) {
        // 檢查每一列
        for (int row = 0; row < SIZE; row++) {
            char first = board[row][0];
            boolean allSame = first != EMPTY;
            for (int col = 1; col < SIZE && allSame; col++) {
                if (board[row][col] != first) {
                    allSame = false;
                }
            }
            if (allSame) return first;
        }

        // 檢查每一行
        for (int col = 0; col < SIZE; col++) {
            char first = board[0][col];
            boolean allSame = first != EMPTY;
            for (int row = 1; row < SIZE && allSame; row++) {
                if (board[row][col] != first) {
                    allSame = false;
                }
            }
            if (allSame) return first;
        }

        // 主對角線
        char diag1 = board[0][0];
        boolean diag1Same = diag1 != EMPTY;
        for (int i = 1; i < SIZE && diag1Same; i++) {
            if (board[i][i] != diag1) {
                diag1Same = false;
            }
        }
        if (diag1Same) return diag1;

        // 反對角線
        char diag2 = board[0][SIZE - 1];
        boolean diag2Same = diag2 != EMPTY;
        for (int i = 1; i < SIZE && diag2Same; i++) {
            if (board[i][SIZE - 1 - i] != diag2) {
                diag2Same = false;
            }
        }
        if (diag2Same) return diag2;

        return EMPTY;
    }

    // 判斷是否平手（棋盤已滿）
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);

        while (true) {
            boolean placed = false;

            while (!placed) {
                System.out.printf("玩家 %c 請輸入座標 (row col)：", currentPlayer);
                int row = sc.nextInt();
                int col = sc.nextInt();
                placed = placePiece(board, row, col, currentPlayer);
            }

            printBoard(board);

            char winner = checkWinner(board);
            if (winner != EMPTY) {
                System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                break;
            } else if (isBoardFull(board)) {
                System.out.println("\n🤝 平手！");
                break;
            }

            // 切換玩家
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        sc.close();
    }
}

