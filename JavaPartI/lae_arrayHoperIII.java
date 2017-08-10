public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    int n = array.length;
    if (n == 1) {
      return array[0] > 0 ? 1 : -1;
    }
    int[] dp = new int[n];
    int minval = n;
    for (int j = 1 ; j < n; j++) {
      dp[j] = -1;
      for (int i = 0; i < j; i++) {
        if (dp[i] != -1 && i + array[i] >= j) {
          dp[j] = 1 + dp[i];
          break;
        }
      }
      if (dp[j] > 0 && j + array[j] > n - 1) {
        minval = Math.min(minval, dp[j] + 1);
      }
    }
    return minval == n ? -1 : minval;
  }
}
