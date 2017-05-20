public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return 0;
    }
    int n = array.length;
    int maxval = Integer.MIN_VALUE;
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if (array[i - 1] == 1) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 0;
      }
      maxval = Math.max(maxval, dp[i]);
    }
    return maxval;
  }
}
