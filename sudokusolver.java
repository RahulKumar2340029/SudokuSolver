import java.util.Scanner;

public class sudokusolver {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Solve(int[][] board, int i, int j) {
        if (i == board.length) {
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            Solve(board, ni, nj);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (isValid(board, i, j, k)) {
                    board[i][j] = k;
                    Solve(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(int[][] board, int x, int y, int val) {
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == val) {
                return false;
            }
        }

        int row = (x / 3) * 3;
        int col = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = in.nextInt();
            }
        }
        Solve(board, 0, 0);
    }
}
