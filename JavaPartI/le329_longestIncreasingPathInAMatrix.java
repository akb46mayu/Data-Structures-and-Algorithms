/* Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.  */

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, longPath(matrix, i, j, dp));
            }
        }
        return max;
    }
    
    private int longPath(int[][] matrix, int x, int y, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int max = 1;
        int m = matrix.length, n = matrix[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int newx = x + dx[k];
            int newy = y + dy[k];
            if (newx >= 0 && newx < m && newy >= 0 && newy < n && matrix[x][y] < matrix[newx][newy]) {
                max = Math.max(max, 1 + longPath(matrix, newx, newy, dp));
            } 
        }
        dp[x][y] = max;
        return max;
    }
}
