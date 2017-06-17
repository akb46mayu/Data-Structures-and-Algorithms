public class Solution {
  public String longestCommon(String s, String t) {
    // Write your solution here.
    int n1 = s.length(), n2 = t.length();
    String out = "";
    int maxlen = 0;
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        int k = i, l = j;
        StringBuilder temp = new StringBuilder();
        int templen = 0;
        while (k < n1 && l < n2 && s.charAt(k) == t.charAt(l)) {
          temp.append(s.charAt(k));
          k++;
          l++;
          templen++;
        }
        if (templen > maxlen) {
          maxlen = templen;
          out = temp.toString();
        }
      }
    }
    return out;
  }
}
