// dp[i]: whether i can be reached through jumping at k in [0, i - 1], k has to be reached
public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here.
    int n = array.length;
    boolean[] dp = new boolean[n];
    dp[0] = true;
    for (int i = 1; i <= n - 1; i++) {
      for (int k = 0; k <= i - 1; k++) {
        dp[i] = false; // we do not need this
        if (dp[k] == true && array[k] + k >= i) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n - 1];
  }
}
