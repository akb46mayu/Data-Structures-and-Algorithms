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
///// way 2, use string builder

public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    isParen(n, 0, 0, sb, res);
    return res;
    
  }
  
  private void isParen(int n, int left, int right, StringBuilder sb, List<String> res) {
    if (sb.length() == 2 * n) {
       if (left * 2 == sb.length()) {
         res.add(sb.toString());
       }
       return;
    }
    
    if (left >= right) {
      isParen(n, left + 1, right, sb.append('('), res);
    } else {
      return;
    }
    sb.deleteCharAt(sb.length() - 1);
    if (left > right) {
      isParen(n, left, right + 1, sb.append(')'), res);
    } else {
      return;
    }
    sb.deleteCharAt(sb.length() - 1);
  }
  
}
