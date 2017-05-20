// space O(n)
public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return 0;
    }
    int n = array.length, maxval = Integer.MIN_VALUE;
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = Math.max(array[i - 1], dp[i - 1] + array[i - 1]);
      maxval = Math.max(dp[i], maxval);
    }
    return maxval;
  }
}

//// space O(1)
public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return 0;
    }
    int n = array.length, maxval = Integer.MIN_VALUE;
    int cursum = 0, prevsum = 0;
    for (int i = 1; i <= n; i++) {
      cursum = Math.max(array[i - 1], prevsum + array[i - 1]);
      maxval = Math.max(cursum, maxval);
      prevsum = cursum;
    }
    return maxval;
  }
}
