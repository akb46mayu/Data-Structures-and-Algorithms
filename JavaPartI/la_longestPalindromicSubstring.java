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

/////////////////////////////////////////////////////
public class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();
    int l;
    int r;
    int maxlen = 0;
    String res = "";
    for (int i = 0; i < 2 * n - 1; i++) {
      if (i % 2 == 0) {
        l = i / 2;
        r = l;
      } else {
        l = i / 2;
        r = l + 1;
      }
      while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
      }
      l++;
      r--;
      if (r - l + 1 > maxlen) {
        res = s.substring(l, r + 1);
        maxlen = r - l + 1;
      }
    }
    return res;
  }
}
// the if else blocks for l, r can also be condensed as:
int l = i / 2;
int r = i % 2 == 0 ? l : l + 1;
