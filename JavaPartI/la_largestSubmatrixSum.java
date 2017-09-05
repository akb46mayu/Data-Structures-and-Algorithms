public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    int maxval = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      int[] temprow = new int[n];
      for (int j = i; j < m; j++) {
        colSum(temprow, matrix[j]);
        maxval = Math.max(maxval, subLSum(temprow));
      }
    }
    return maxval;
  }
  private void colSum(int[] temprow, int[] rmatrix) {
    int n = rmatrix.length;
    for (int i = 0; i < n; i++) {
      temprow[i] += rmatrix[i];
    }
  }
  
  private int subLSum(int[] temprow) {
    int n = temprow.length;
    int prev = 0, cur = 0;
    int maxval = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      cur = Math.max(temprow[i], prev + temprow[i]);
      prev = cur;
      maxval = Math.max(cur, maxval);
    }
    return maxval;
  }
  
}
//// way 2

public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[][] colsum = new int[m + 1][n];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          colsum[i][j] = 0;
        } else if (i == 1) {
          colsum[i][j] = matrix[i - 1][j];
        } else {
          colsum[i][j] = colsum[i - 1][j] + matrix[i - 1][j]; 
        }
      }
    }
    //
    int[] dp = new int[n];
    int max = Integer.MIN_VALUE;
    for (int k = 1; k <= m; k++) {
      for (int i = 0; i < k; i++) {
        for (int j = 0; j < n; j++) {
          int cur = colsum[k][j] - colsum[i][j];
          if (j == 0) {
            dp[j] = cur;
          } else {
            dp[j] = Math.max(cur, dp[j - 1] + cur);
          }
          max = Math.max(max, dp[j]);
        }
      }
    }
    return max;
  }
}
