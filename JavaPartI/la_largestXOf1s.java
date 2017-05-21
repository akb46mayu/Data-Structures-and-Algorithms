public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[][] temp1 = leftUp(matrix, m, n);
    int[][] temp2 = rightDown(matrix, m, n);
    return merge(temp1, temp2, m, n);
  }
  
  private int[][] leftUp(int[][] matrix, int m, int n) {
    // start at leftup corner move to l and down
    int[][] LU = new int[m][n]; // start at left up corner to the center
    int[][] RU = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          LU[i][j] = checkBound(LU, i - 1, j - 1, m, n) + 1;
          RU[i][j] = checkBound(RU, i - 1, j + 1, m, n) + 1;
        }
      }
    }
    merge(LU, RU, m, n);
    return LU;
  }
  
    private int[][] rightDown(int[][] matrix, int m, int n) {
    // start at leftup corner move to l and down
    int[][] LD = new int[m][n]; // start at left up corner to the center
    int[][] RD = new int[m][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          LD[i][j] = checkBound(LD, i + 1, j - 1, m, n) + 1;
          RD[i][j] = checkBound(RD, i + 1, j + 1, m, n) + 1;
        }
      }
    }
    merge(LD, RD, m, n);
    return LD;
  }
  
  private int merge(int[][] A, int[][] B, int m, int n) {
    // put min value matrix into A
    int maxval = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Math.min(A[i][j], B[i][j]);
        maxval = Math.max(A[i][j], maxval);
      }
    }
    return maxval;
  }
  
  private int checkBound(int[][] matrix, int i, int j, int m, int n) {
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return 0;
    }
    return matrix[i][j];
  } 
}
