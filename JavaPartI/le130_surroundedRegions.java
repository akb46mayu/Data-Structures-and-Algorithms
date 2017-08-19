/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

class Pair {
    int x;
    int y;
    int val;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public void solve(char[][] board) {
        // corner case
        if (board == null) {
            return;
        }
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        // bfs
        for (int j = 0; j < n; j++) {
            bfs(0, j, board);
            bfs(m - 1, j, board);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, 0, board);
            bfs(i, n - 1, board);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(int x0, int y0, char[][] board) {
        if (board[x0][y0] != 'O') {
            return;
        }
        int m = board.length, n = board[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x0, y0));
        board[x0][y0] = 'W';
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int x = temp.x, y = temp.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }
}
