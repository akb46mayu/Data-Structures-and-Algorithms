// dp[i][j] : max number of ones inside the matrix with (0,0) and (i, j) as the top left and botom right corner
public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[n + 1][n + 1];
    int result = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i - 1][j - 1] == 1) {
          int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], temp);
        } else {
          dp[i][j] = 0;
        }
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }
}

///// same idea but use less spaces

public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[n][n];
    int maxval = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          if (matrix[i][j] == 1) {
            dp[i][j] = 1;
          }
        } else {
          if (matrix[i][j] == 0) {
            dp[i][j] = 0;
          } else {
            int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
            dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
          }
        }
        maxval = Math.max(dp[i][j], maxval);
      }
    }
    return maxval;
  }
}
