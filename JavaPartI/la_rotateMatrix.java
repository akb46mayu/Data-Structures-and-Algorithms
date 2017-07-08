public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    if (n <= 1) {
      return;
    }
    int k = n;
    for (int i = 0; i < n /2; i++) {
      for (int j = 0; j < k - 1; j++) {
        int temp = matrix[i + k - 1 - j][i];
        matrix[i + k - 1 - j][i] = matrix[i + k - 1][i + k - 1 - j];
        matrix[i + k - 1][i + k - 1 -j] = matrix[i + j][i + k - 1];
        matrix[i + j][i + k - 1] = matrix[i][i + j];
        matrix[i][i + j] = temp;
      }
      k -= 2;
    }
  }
}
//////

public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    int i = -1;
    for (int l = n; l > 0; l = l - 2) {
      i = i + 1;
      for (int k = 0; k < l - 1; k++) {
        int temp = matrix[i + l - 1 - k][i];
        matrix[i + l - 1 - k][i] = matrix[i + l - 1][i + l - 1 - k];
        matrix[i + l - 1][i + l - 1 - k] = matrix[i + k][i + l -1];
        matrix[i + k][i + l - 1] = matrix[i][i + k];
        matrix[i][i + k] = temp;
      }
    }
  }
}
