// dp[i]: min steps start from the range: [0, i - 1]

public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    int n = array.length;
    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 1; i <= n - 1; i++) {
      dp[i] = -1;
      for (int k = 0; k <= i - 1; k++) {
        if (dp[k] != -1 && array[k] + k >= i) {
          dp[i] = dp[k] + 1;
          break;
        }
      }
    }
    return dp[n - 1];
  }
}
