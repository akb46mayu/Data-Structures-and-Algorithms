//// strstr


public class Solution {
  public int strstr(String large, String small) {
    // write your solution here
    if (small.length() == 0) {
      return 0;
    }
    int n = large.length();
    int slen = small.length();
    for (int i = 0; i <= n - slen; i++) {
      int start = i;
      int count = 0;
      for (int j = 0; j < slen; j++) {
        if (small.charAt(j) == large.charAt(start)) {
          count++;
          start++;
        }
      }
      if (count == slen) {
    	  return start - slen;
      }
    }
    return -1;
  }
}
