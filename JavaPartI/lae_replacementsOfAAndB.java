public class Solution {
  public int minReplacements(String input) {
    // Write your solution here.
    int n = input.length();
    if (n <= 1) {
      return 0;
    }
    int[] dpa = new int[n];
    int[] dpb = new int[n];
    // for generating dpa
    for (int i = 0; i < n; i++) {
      char ch = input.charAt(i);
      if (i == 0) { //?>
        if (ch == 'b') {
           dpa[i] = 1;
        }
       
      } else {
        if (ch =='a') {
          dpa[i] = dpa[i - 1];
        } else {
          dpa[i] = dpa[i - 1] + 1;
        }
      }
    }
    // for generating dpb
    for (int i = n - 1; i >= 0; i--) {
      char ch = input.charAt(i);
      if (i == n - 1) { //?>
        if (ch == 'a') {
         dpb[i] = 1;
        }
      } else {
        if (ch =='b') {
          dpb[i] = dpb[i + 1];
        } else {
          dpb[i] = dpb[i + 1] + 1;
        }
      }
    }
    // general
    int res = n;
    for (int i = 0; i < n - 1; i++) {
      res = Math.min(res, dpa[i] + dpb[i + 1]);
    }
    int temp = Math.min(dpa[n - 1], dpb[0]);
    return Math.min(res, temp);
  }
}
