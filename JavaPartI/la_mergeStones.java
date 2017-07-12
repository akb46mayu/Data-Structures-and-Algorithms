public class Solution {   // use position as physical meanings
  public int minCost(int[] stones) {
    // Write your solution here.
    int n = stones.length;
    int[][] cost = new int[n][n];
    int[][] subSum = new int[n][n];
    for (int j = 0; j < n; j++) {
      for (int i = j; i >= 0; i--) {
        if (i == j) {
          subSum[i][j] = stones[i];
          cost[i][j] = 0;
        } else {
          cost[i][j] = Integer.MAX_VALUE;
          subSum[i][j] = subSum[i + 1][j] + stones[i];
          for (int k = i; k < j; k++) {
            cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k+1][j] + subSum[i][j]);
          }
        }
      }
    }
    return cost[0][n - 1];
  }
}

/// 
public class Solution2 {   // use length as phytsical meanings
  public int minCost(int[] stones) {
    // Write your solution here.
    int n = stones.length;
    int[][] dp = new int[n + 1][n + 1];
    int[] sum = new int[n + 1];
    for (int j = 1; j <= n; j++) {
      sum[j] = sum[j - 1] + stones[j - 1];
      for (int i = j; i >= 1; i--) {
        if (j - i >= 2) { 
          dp[i][j] = Integer.MAX_VALUE;
          for (int k = i; k<= j - 1; k++) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
          }
          dp[i][j] = dp[i][j] + sum[j] - sum[i - 1];
        } else if (j - i == 1) {
          dp[i][j] = sum[j] - sum[i - 1];
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return dp[1][n];
  }
}
