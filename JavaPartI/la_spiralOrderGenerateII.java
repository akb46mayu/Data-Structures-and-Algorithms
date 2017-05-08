// print row's whole elements , print col's part elements excluding up and down
// left, right are row direction's two pointers. columwise

public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    // Write your solution here.
    int[][] result = new int[m][n];
    int num = 1;
    int left = 0, right = n - 1;
    int up = 0, down = m - 1;
    while (left < right && up < down) {
      for (int j = left; j <= right; j++) {
        result[up][j] = num++;
      }
      for (int i = up + 1; i <= down - 1; i++) {
        result[i][right] = num++;
      }
      for (int j = right; j >= left; j--) {
        result[down][j] = num++;
      }
      for (int i = down - 1; i >= up + 1; i--) {
        result[i][left] = num++;
      }
      up++;
      down--;
      left++;
      right--;
    }
    if (left > right || up > down) {
      return result;
    } else if (left == right) {
      for (int i = up; i <= down; i++) {
        result[i][left] = num++;
      }
    } else {
      for (int j = left; j <= right; j++) {
        result[up][j] = num++;
      }
    }
    return result;
  }
}
