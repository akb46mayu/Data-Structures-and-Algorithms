public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here.
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> cur = new ArrayList<Integer>();
    nqHelper(n, cur, result);
    return result;
  }
  private void nqHelper(int n, List<Integer> cur, List<List<Integer>> result) {
    if (cur.size() == n) {  // use temp list's size to determine the row value
      result.add(new ArrayList<Integer>(cur));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (checkValid(cur, i)) {
        cur.add(i);
        nqHelper(n, cur, result);
        cur.remove(cur.size() - 1);
      }
    } 
  }
  private boolean checkValid(List<Integer> cur, int col) {
    int row = cur.size();
    for (int i = 0; i < row; i++) {
      if (cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) {  // instead of using hash, simply check two coordinates
        return false;
      }
    }
    return true;
  }
}
