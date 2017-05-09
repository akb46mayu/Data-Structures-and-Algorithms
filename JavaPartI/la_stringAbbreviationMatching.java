public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    return matchHelper(input, pattern, 0, 0);
  }
  private boolean matchHelper(String s, String t, int si, int ti) {
    if (si == s.length() && ti == t.length()) {
      return true;
    } 
    if (si >= s.length() || ti >= t.length()) {
      return false;
    }
    if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
      if (s.charAt(si) == t.charAt(ti)) {
        return matchHelper(s, t, si + 1, ti + 1);
      } 
      return false;
    } else {
      int count = 0;
      while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
        count = count * 10 + (t.charAt(ti) - '0');
        ti++;
      }
      return matchHelper(s, t, si + count, ti);
    }
  }
}
