public class Solution {
  private static final char[] cset = {'(', ')', '[', ']', '{', '}'};
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here.
    StringBuilder temp = new StringBuilder();
    List<String> res = new ArrayList<>();
    Deque<Character> stack = new LinkedList<>();
    int[] remain = {l, l, m, m, n, n};
    int targetlen = 2 * (m + l + n);
    validParen(res, temp, stack, remain, targetlen);
    return res;
  }
  
  private void validParen(List<String> res, StringBuilder temp, Deque<Character> stack, int[] remain, int targetlen) {
    if (temp.length() == targetlen) {
      res.add(temp.toString());
      return;
    }
    for (int i = 0; i < remain.length; i++) {
      if (i % 2 == 0) { // for the left paren
        if (remain[i] > 0) {
          stack.offerFirst(cset[i]);
          remain[i]--;
          temp.append(cset[i]);
          validParen(res, temp, stack, remain, targetlen);
          stack.pollFirst();
          remain[i]++;
          temp.deleteCharAt(temp.length() - 1);
        }
      } else {
        if (!stack.isEmpty() && stack.peekFirst() == cset[i - 1]) {
          stack.pollFirst();
          remain[i]--;
          temp.append(cset[i]);
          validParen(res, temp, stack, remain, targetlen);
          stack.offerFirst(cset[i - 1]);
          remain[i]++;
          temp.deleteCharAt(temp.length() - 1);
        }
      }
    }
  }
  
}
