public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    int n = array.length;
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n];
    int glbmax = 0;
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int locmax = 0;
      for (int j = 0; j < i; j++) {
        dp[i] = Math.max(dp[i], dp[j] + (array[i] > array[j] ? 1 : 0));
      }
      glbmax = Math.max(dp[i], glbmax);
    }
    return glbmax;
  }
}
