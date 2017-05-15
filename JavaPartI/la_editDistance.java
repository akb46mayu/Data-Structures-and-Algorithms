public class Solution {
  public int editDistance(String one, String two) {
    // Write your solution here.
    int m = one.length(), n = two.length();
    if (m == 0 && n == 0) {
      return 0;
    }
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          dp[0][j] = j;
        } else if (j == 0) {
          dp[i][0] = i;
        } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int temp = Math.min(dp[i- 1][j - 1] + 1, dp[i - 1][j] + 1);
          dp[i][j] = Math.min(temp, dp[i][j - 1] + 1);
        }
      }
    }
    return dp[m][n];
  }
}

//////// saving space

public class Solution {
  public int editDistance(String one, String two) {
    // Write your solution here.
    int m = one.length(), n = two.length();
    if (m == 0 && n == 0) {
      return 0;
    }
    int[][] dp = new int[2][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          dp[0][j] = j;
        } else if (j == 0) {
          dp[i % 2][0] = i;
        } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
        } else {
          int temp = Math.min(dp[(i - 1) % 2][j - 1] + 1, dp[(i - 1) % 2][j] + 1);
          dp[i % 2][j] = Math.min(temp, dp[i % 2][j - 1] + 1);
        }
      }
    }
    return dp[m % 2][n];
  }
}
