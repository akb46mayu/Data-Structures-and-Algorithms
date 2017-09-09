
public class Solution {
  public double largest(double[][] matrix) {
    // write your solution here
    double rmin = 1;
    double rmax = 1;
    double max = Long.MIN_VALUE;
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int k = 0; k <= i; k++) {
         for (int j = 0; j < n; j++) {
           double prod = getColproduct(matrix, k, i, j);
           double temp;
           if (j == 0) {
             rmin = prod;
             rmax = prod;
           } else {
             temp = rmin;
             rmin = Math.min(prod, Math.min(rmin * prod, rmax * prod));
             rmax = Math.max(prod, Math.max(temp * prod, rmax * prod));
           }
           max = Math.max(max, rmax);
         }
      }
    }
    return max;
  }
  
  private double getColproduct(double[][] matrix, int x1, int x2, int j) {
    int m = matrix.length, n = matrix[0].length;
    double res = 1.0;
    for (int i = x1; i <= x2; i++) {
      res *= matrix[i][j];
    }
    return res;
  }
}
