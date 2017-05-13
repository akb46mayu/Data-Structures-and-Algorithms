public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int n = array.length, globalMax = 1;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i <= n - 1; i++) {
      if (array[i] > array[i - 1]) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 1;
      }
      if (dp[i] > globalMax) {
        globalMax = dp[i];
      }
    }
    return globalMax;
  }
}
