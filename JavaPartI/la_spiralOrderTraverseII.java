public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
     List<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return result;
    }
    spiralHelper(matrix, matrix[0].length, matrix.length, 0, result);
    return result;
  }
  
  private void spiralHelper(int[][] matrix, int sizew, int sizeh, int offset, List<Integer> result) {
    if (sizew == 0 || sizeh == 0) {
      return;
    }  
    if (sizew == 1 && sizeh == 1) {
      result.add(matrix[offset][offset]);
      return;
    } else if (sizeh == 1) {  // base case one one row or one column is left
      for (int k = 0; k < sizew; k ++) {
        result.add(matrix[offset][offset + k]);
      }
      return;
    } else if (sizew == 1) {
      for (int k = 0; k < sizeh; k ++) {
        result.add(matrix[offset + k][offset]);
      }
      return;
    } 
    int p = offset;
    for (int k = 0; k < sizew - 1; k++) {
      result.add(matrix[p][p + k]);
    }
    for (int k = 0; k < sizeh - 1; k++) {
      result.add(matrix[p + k][p + sizew - 1]);
    }
    for (int k = 0; k < sizew - 1; k++) {
      result.add(matrix[p + sizeh - 1][p + sizew - 1 - k]);
    }
    for (int k = 0; k < sizeh - 1; k++) {
      result.add(matrix[p + sizeh - 1 - k][p]);
    }
    spiralHelper(matrix, sizew - 2, sizeh - 2, offset + 1, result);
  }
  
}
