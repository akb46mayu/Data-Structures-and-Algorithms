public class Solution {
  public int numOfTrees(int n) {
    // Write your solution here.
    
    if (n == 0) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int j = 2; j <= n; j++) {
      for (int i = 0; i < j; i++) {
        dp[j] += dp[i] * dp[j - i - 1];
      }
    }
    return dp[n];
  }
}
