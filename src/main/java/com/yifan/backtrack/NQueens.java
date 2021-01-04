package com.yifan.backtrack;

import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        backtrack(result, chess, 0);
        return result;
    }

    private void backtrack(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                backtrack(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }

    }

    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，
        //我们只需要检查走过的行数即可，通俗一点就是判断当前
        //坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> path = new LinkedList<>();
        for (char[] chars : chess) {
            path.add(new String(chars));
        }
        return path;
    }

}
