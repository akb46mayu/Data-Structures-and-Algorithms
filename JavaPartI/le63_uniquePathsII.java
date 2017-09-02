// way 1
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        boolean rowtag = false;
        boolean coltag = false;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = obstacleGrid[i][j];
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else if (i == 0) {
                    if (rowtag == false) {
                        if (cur == 1) {
                            rowtag = true;
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = 1;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (coltag == false) {
                        if (cur == 1) {
                            coltag = true;
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = 1;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = cur != 1 ? dp[i - 1][j] + dp[i][j - 1] : 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
