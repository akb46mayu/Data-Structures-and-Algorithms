public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    char[] curstring = new char[2 * n]; 
    helper(curstring, result, 0, 0, 0, n);
    return result;
  }
  
  private void helper(char[] curstring, List<String> result, int index, int l, int r, int n) {
    if ((l + r) == 2 * n) {
      result.add(new String(curstring));
      return;
    }
    if (l < n) {
      curstring[index] = '(';
      helper(curstring, result, index + 1, l + 1, r, n);
    }
    if (r < l) {
      curstring[index] = ')';
      helper(curstring, result, index + 1, l, r + 1, n);
    }
  }
  
}
