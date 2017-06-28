public class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n <= 1) {
      return s;
    }
    String res = "";
    int maxlen = 0;
    for (int i = 0; i < n; i++) {
      int l = i, r = i;
      int len = 0;
      while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        len = l == i ? 1 : len + 2;
        l--;
        r++;
      }
      l++;
      r--;
      if (len > maxlen) {
        res = s.substring(l, r + 1);
        maxlen = len;
      }
    }
    for (int i = 0; i < n- 1; i++) {
      int l = i, r = i + 1;
      int len = 0;
      while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        len += 2;
        l--;
        r++;
      }
      l++;
      r--;
      if (len > maxlen) {
        res = s.substring(l, r + 1);
        maxlen = len;
      }
    }
    return res;
  }
}
