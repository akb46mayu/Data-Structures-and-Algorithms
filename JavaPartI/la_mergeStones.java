public class Solution {
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
