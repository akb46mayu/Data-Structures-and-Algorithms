// recursion
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

//// iteration: firstly check alphabetic, then digit, consider length prolblems of two strings
public class Solution2 {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    if (input.length() == 0 && pattern.length() == 0) {
      return true;
    } else if (input.length() == 0 || pattern.length() == 0) {
      return false;
    } 
    int j = 0, i = 0;
    while (j < pattern.length()) {
      if (i >= input.length()) {
        return false;
      }
      if ((pattern.charAt(j) - '0') < 0 || (pattern.charAt(j) - '0') > 9) { // it is an alphabatic 
        if (input.charAt(i) != pattern.charAt(j)) {
          return false;
        }
        i++;
        j++;
      } else {  // it is a digit
        int prevsum = 0;
        while (j < pattern.length() && (pattern.charAt(j) - '0') >= 0 && (pattern.charAt(j) - '0') <= 9) {
            prevsum = prevsum * 10 + (pattern.charAt(j) - '0');
            j++;
        }
        i += prevsum;
      }
    }
    return i == input.length();

  }
}
