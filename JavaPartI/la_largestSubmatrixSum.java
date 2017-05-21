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
