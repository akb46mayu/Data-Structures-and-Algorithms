public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    int[] res = {-1, -1};
    int m = matrix.length; 
    if (m == 0) {
      return res;
    }
    int n = matrix[0].length;
    int i = 0, j = n - 1;
    while (i < m && j >= 0) {
      if (target == matrix[i][j]) {
        return new int[]{i, j};
      } else if (target < matrix[i][j]) {
        j -= 1;
      } else {
        i += 1;
      }
    }
    return res;
  }
}
