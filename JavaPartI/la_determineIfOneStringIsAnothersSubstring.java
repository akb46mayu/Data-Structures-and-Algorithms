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
    if (small == null || small.length() == 0) {
      return 0;
    } 
    if (large == null || large.length() == 0) {
      return -1;
    }
    int lenl = large.length(), lens = small.length();
    if (lens > lenl) {
      return - 1;
    }
    for (int i = 0; i <= lenl - lens; i++) {
      if (checkStr(large, small, i)) {
        return i;
      }
    }
    return -1;
    
  }
  private boolean checkStr(String large, String small, int start) {
    int lenl = large.length(), lens = small.length();
    for (int j = 0; j < lens; j++) {
      if (small.charAt(j) != large.charAt(start)) {
        return false;
      }
      start++;
    }
    return true;
  }
}
