package ru.job4j.puzzle;

public class Win {
    public static boolean WinHorizontal(int[][] board) {
        boolean rsl = false;
            for (int i = 0; i < board.length; i++) {
                int H = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    H++;
                }
                if (H == board.length) {
                    rsl = true;
                    break;
                }
            }
        }
            return rsl;
    }

    public static boolean WinVertical(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            int H = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 1) {
                    H++;
                }
                if (H == board.length) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean rsl = true;
        rsl = WinHorizontal(board) || WinVertical(board);
        return rsl;
    }

}
