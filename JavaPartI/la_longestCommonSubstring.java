public class Solution { // brute force T = O(mnp)
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


public class Solution { // brute force way 2, use offset
  public String longestCommon(String s, String t) {
    // Write your solution here.
    StringBuilder sb = new StringBuilder();
    int n1 = s.length();
    int n2 = t.length();
    int maxlen = 0;
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        int k = 0;
        int templen = 0;
        StringBuilder tempsb = new StringBuilder();
        while (i + k < n1 && j + k < n2 && s.charAt(i + k) == t.charAt(j + k)) {
          tempsb.append(s.charAt(i + k));
          k++;
          templen++;
        }
        if (templen > maxlen) {
          sb = tempsb;
          maxlen = templen;
        }
      }
    }
    return sb.toString();
  }
}

////  dp solution O(mn)
public class Solution2 {
  public String longestCommon(String s, String t) {
    // Write your solution here.
    StringBuilder sb = new StringBuilder();
    int n1 = s.length();
    int n2 = t.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    int maxlen = 0;
    int end = -1;
    int start = 0;
    for (int i = 1; i < n1 + 1; i++) {
      for (int j = 1; j < n2 + 1; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (dp[i][j] > maxlen) {
            end = j - 1;
            maxlen = dp[i][j];
            start = j - maxlen; 
          }
        }
      }
    }
    return t.substring(start, end + 1);
  }
}
