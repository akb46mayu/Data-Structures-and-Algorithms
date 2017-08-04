// assume: input is a square matrix and not null. 
// size: the height or the width of the current matrix
// recursion 
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

/// iterative 
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0) {
      return res;
    }
    int n = matrix.length; // at least one element
    int edge = n;
    for (int s = 0; s <= n / 2; s++) {
      if (edge == 1) {
        res.add(matrix[s][s]);
        break;
      }
      for (int j = 0; j < edge - 1; j++) {
        res.add(matrix[s][s + j]);
      }
      for (int i = 0; i < edge - 1; i++) {
        res.add(matrix[s + i][s + edge - 1]);
      }
      for (int j = 0; j < edge - 1; j++) {
        res.add(matrix[s + edge - 1][s + edge - 1- j]);
      }
      for (int i = 0; i < edge - 1; i++) {
        res.add(matrix[s + edge - 1 - i][s]);
      }
      edge -= 2;    
    }
    return res;
  }
}

