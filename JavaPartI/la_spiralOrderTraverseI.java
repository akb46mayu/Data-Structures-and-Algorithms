// assume: input is a square matrix and not null. 
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    int size = matrix.length;
    spiralHelper(matrix, size, 0, result);
    return result;
  }
  

  private void spiralHelper(int[][] matrix, int size, int offset, List<Integer> result) {
    if (size == 0) {
      return;
    }
    if (size == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    int i1 = offset, j1 = offset;  // i1 and j1 are the same can be represented by offset as well
    for (int k = 0; k < size - 1; k++) {
      result.add(matrix[i1][j1 + k]);
    }
    for (int k = 0; k < size - 1; k++) {
      result.add(matrix[i1 + k][j1 + size - 1]);
    }
    for (int k = 0; k < size - 1; k++) {
      result.add(matrix[i1 + size -1][j1 + size - k -1]);
    }
    for (int k = 0; k < size - 1; k++) {
      result.add(matrix[i1 + size -k -1][j1]);
    }
    spiralHelper(matrix, size - 2, offset + 1, result);
  }

}
