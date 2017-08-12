public class Solution {
  public int minCuts(String input) {
    // Write your solution here.
    char[] arr = input.toCharArray();
    int n = arr.length;
    if (n == 0) {
      return 0;
    }
    int[] mincut = new int[n];
    boolean[][] pal = new boolean[n][n];
    for (int j = 0; j < n; j++) {
      mincut[j] = j;
      for (int i = j; i >= 0; i--) {
        if (arr[i] == arr[j]) {
          if (j - i <= 1) {
            pal[i][j] = true;
          } else if (i + 1 >= 0 && pal[i + 1][j - 1] == true) {
            pal[i][j] = true;
          }
        }
        if (i >= 1 && pal[i][j] == true) {
          mincut[j] = Math.min(mincut[j], mincut[i - 1] + 1);
        } else if (i == 0 && pal[i][j] == true) {
          mincut[j] = 0;
        }
      }
    }
    return mincut[n - 1];
  }
}
//// way 2 diff logic 
public class Solution {
  public int minCuts(String input) {
    // Write your solution here.
    int n = input.length();
    if (n <= 1) {
      return 0;
    }
    boolean[][] pal = new boolean[n][n];
    int[] dp = new int[n];
    for (int j = 1; j < n; j++) {
      dp[j] = j;
      for (int i = j; i >= 0; i--) {
        if (input.charAt(i) == input.charAt(j)) {
          if (j - i <= 1) {
            pal[i][j] = true;
          } else {
            pal[i][j] = pal[i + 1][j - 1] == true ? true : false;
          }
        }
        if (pal[i][j] == true) {
          if (i == 0) {
            dp[j] = 0;
          } else {
            dp[j] = Math.min(dp[j], dp[i - 1] + 1);
          }
        }
      }
    }
    return dp[n - 1];
  }
}
