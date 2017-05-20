public class Solution {
	  public int largest(int[][] matrix) {
	    // Write your solution here.
	    if (matrix.length == 0 || matrix[0].length == 0) {
	      return 0;
	    }
	    int m = matrix.length, n = matrix[0].length;
	    int[][] temp1 = leftup(matrix, m, n);
	    int[][] temp2 = rightdown(matrix, m, n);
	    return merge(temp1, temp2);
	  }
	  // merge two matrix according to the min val and modify it in A in place, return the global max edge length
	  private int merge(int[][] A, int[][] B) {
	    int m = A.length, n = A[0].length;
	    int result = 0;
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        A[i][j] = Math.min(A[i][j], B[i][j]);
	        result = Math.max(A[i][j], result);
	      }
	    }
	    return result;
	  }
          // combine left and up matrix
	  private int[][] leftup(int[][] matrix, int m, int n) {
	    int[][] left = new int[m][n];
	    int[][] up = new int[m][n];
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (matrix[i][j] == 1) {
	          if (i == 0 && j == 0) {
	            left[i][j] = 1;
	            up[i][j] = 1;
	          } else if (i == 0) {
	            up[i][j] = 1;
	            left[i][j] = left[i][j - 1] + 1;
	          } else if (j == 0) {
	            left[i][j] = 1;
	            up[i][j] = up[i - 1][j] + 1;
	          } else {
	            up[i][j] = up[i - 1][j] + 1;
	            left[i][j] = left[i][j - 1] + 1;
	          }
	        }
	      }
	    }
	    merge(left, up);
	    return left;
	  }
	// combine right and down matrix
	  private int[][] rightdown(int[][] matrix, int m, int n) {
	    int[][] right = new int[m][n];
	    int[][] down = new int[m][n];
	    for (int i = m - 1; i >= 0; i--) {
	      for (int j = n - 1; j >= 0; j--) {
	        if (matrix[i][j] == 1) {
	          if (i == m - 1 && j == n - 1) {
	            right[i][j] = 1;
	            down[i][j] = 1;
	          } else if (i == m - 1) {
	            right[i][j] = right[i][j + 1] + 1;
	            down[i][j] = 1;
	          } else if (j == n - 1) {
	            right[i][j] = 1;
	            down[i][j] = down[i + 1][j] + 1;
	          } else {
	        	right[i][j] = right[i][j + 1] + 1;
	        	down[i][j] = down[i + 1][j] + 1;
	          }
	        }
	      }
	    }
	    merge(right, down);
	    return right;
	  }
  
}
