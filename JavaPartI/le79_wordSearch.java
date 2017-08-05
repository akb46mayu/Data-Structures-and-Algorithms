/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.


*/

/// way 1: recursion without return values
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0 || word.length() == 0) {
            return false;
        }
        int n = board[0].length;
        boolean[] res = {false};
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                existHelper(board, i, j, word, 0, res, visited);
                if (res[0] == true) {
                    return res[0];
                }
            }
        }
        return res[0];
    }
    
    private void existHelper(char[][] board, int x, int y, String word, int level, boolean[] res, int[][] visited) {
        char ch = board[x][y];
        if (res[0] == true || ch != word.charAt(level) || level == word.length() - 1) {
            if (ch == word.charAt(level) && visited[x][y] == 0) {
                 res[0] = true;
            }
            return;
        }
        int m = board.length, n = board[0].length; 
        visited[x][y] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int newx = x + dx[k];
            int newy = y + dy[k];
            if (newx >= 0 && newx < m && newy >= 0 && newy < n && visited[newx][newy] == 0) {
                existHelper(board, newx, newy, word, level + 1, res, visited);
            }
        }
        visited[x][y] = 0;
    }
}

/// way 2, this solution pruning more branches, and use recursion with return values.
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0 || word.length() == 0) {
            return false;
        }
        int n = board[0].length;
        boolean[] res = {false};
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean existHelper(char[][] board, int x, int y, String word, int level, int[][] visited) {
        char ch = board[x][y];
        if (ch != word.charAt(level)) {
            return false;
        }
        if (level == word.length() - 1 && visited[x][y] == 0) {
             return true;
        } 
        int m = board.length, n = board[0].length; 
        visited[x][y] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int newx = x + dx[k];
            int newy = y + dy[k];
            if (newx >= 0 && newx < m && newy >= 0 && newy < n && visited[newx][newy] == 0) {
                if (existHelper(board, newx, newy, word, level + 1, visited)) {
                    return true;
                }
            }
        }
        visited[x][y] = 0;
        return false;
    }
    
}
