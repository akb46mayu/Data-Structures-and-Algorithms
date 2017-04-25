public class Solution {
  public int missing(int[] array) {
    // Write your solution here.
    int result = 0;
    int n = array.length + 1;
    for (int i : array) {
      result ^= i;
    }
    for (int j = 1; j <= n; j ++) {
      result ^= j;
    }
    return result;
  }
}
