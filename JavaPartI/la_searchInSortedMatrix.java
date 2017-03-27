//

public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    int m = matrix.length, n = matrix[0].length;
    int left = 0, right = m * n  - 1;
    while (left <= right){
      int mid = left + (right - left)/2;
      int i = mid / n, j = mid % n;
      if (target == matrix[i][j]){
        return new int[] {i, j};
      } else if (target < matrix[i][j]){
        right = mid - 1;
      } else{
        left = mid + 1;
      }
    }
    return new int[] {-1, -1};
  }
}
