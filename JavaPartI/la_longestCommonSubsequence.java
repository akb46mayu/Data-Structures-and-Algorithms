public class Solution {
  public int longest(String s, String t) {
    // Write your solution here. 
    int n1 = s.length(), n2 = t.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n1][n2];
  }
}
