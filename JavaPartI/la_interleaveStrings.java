public class Solution {
  public boolean canMerge(String a, String b, String c) {
    // Write your solution here.
    int n1 = a.length();
    int n2 = b.length();
    int m = c.length();
    if (n1 + n2 != m) {
      return false;
    }
    boolean[][] dp = new boolean[n1 + 1][n2 + 1];
    
    for (int i = 0; i <= n1; i++) {
      for (int j = 0; j <= n2; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        }
        if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
          dp[i][j] |= dp[i - 1][j];
        }
        if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
          dp[i][j] |= dp[i][j - 1]; 
        }
      }
    }
    return dp[n1][n2];
  }
}
