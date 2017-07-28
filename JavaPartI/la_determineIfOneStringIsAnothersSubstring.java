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

// way 2 of implementation


public class Solution {
  public int strstr(String large, String small) {
    int lens = small.length();
    int lenl = large.length();
    if (lens == 0) {
      return 0;
    }
    int start = -1;
    for (int i = 0; i <= lenl - lens; i++) {
      if (checkEqu(large, small, i)) {
        return i;
      }
    }
    return start;
  }
  
  private boolean checkEqu(String large, String small, int s0) {
    int lens = small.length();
    for (int i = 0; i < lens; i++) {
      if (large.charAt(s0 + i) != small.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
