public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return 0;
    }
    int n = array.length, maxval = Integer.MIN_VALUE;
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = Math.max(array[i - 1], dp[i - 1] + array[i - 1]);
      maxval = Math.max(dp[i], maxval);
    }
    return maxval;
  }
}
