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
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        } else {
          dp[i] = Math.max(dp[i], 1);
        }
      }
      glbmax = Math.max(dp[i], glbmax);
    }
    return glbmax;
  }
}

////// way 2
public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    int n = array.length;
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    int res = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j]) { // update dp only when the condition comes true
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
