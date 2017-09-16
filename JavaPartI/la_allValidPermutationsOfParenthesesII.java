public class Solution { // way1 use string builder 
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
/// way 2 using character array

public class Solution {
  public static char[] pool = {'(', ')', '[', ']', '{', '}'};
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    int bits = (l + m + n) * 2;
    int[] stat = {l, l, m, m, n, n};
    char[] temp = new char[bits];
    Deque<Character> stack = new LinkedList<>();
    parenHelper(bits, 0, stat, res, temp, stack);
    return res;
  }
  
  private void parenHelper(int bits, int level, int[] stat, List<String> res, char[] temp, Deque<Character> stack) {
    if (level == bits) {
      res.add(new String(temp));
      return;
    }
    for (int i = 0; i < 6; i++) {
      char ch = pool[i];
      if (i % 2 == 0) { // add left brackets 
        if (stat[i] > 0) {
          temp[level] = ch;
          stack.offerFirst(ch);
          stat[i]--;
          parenHelper(bits, level + 1, stat, res, temp, stack);
          stack.pollFirst();
          stat[i]++;
        }
      } else {
        if (stat[i] > 0 && stack.size() >= 1 && stack.peekFirst() == pool[i - 1]) {
          temp[level] = ch;
          stack.pollFirst();
          stat[i]--;
          parenHelper(bits, level + 1, stat, res, temp, stack);
          stack.offerFirst(pool[i - 1]);
          stat[i]++;
        }
      }
    }
  }
}
