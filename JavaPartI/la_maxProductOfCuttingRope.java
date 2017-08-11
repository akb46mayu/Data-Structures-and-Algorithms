/// dp - dp[i]: max product of rope with length of i, with at least one cut
// sol1:  left big seg, right big seg
public class Solution {
  public int maxProduct(int length) {
    // Write your solution here.
    if (length == 0) {
      return 0;
    }
    int n = length;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int k = 1; k <= i / 2; k++) {
        dp[i] = Math.max(dp[i], Math.max(dp[k], k) * Math.max(dp[i - k], i - k));
      }
    }
    return dp[n];
  }
}
/// sol2 : dp , left bit seg, right small seg

public class Solution2 {
    public int maxProduct(int length) {
      // Write your solution here. 
      int n = length;
      int[] dp = new int[n + 1];
      dp[1] = 1;
      for (int j = 2; j <= n; j++) {
        for (int i = 1; i < j; i++) {
          dp[j] = Math.max(dp[j], Math.max(dp[i], i) * (j - i));
        }
      }
      return dp[n];
    }
}


// recursion + left big, right small
