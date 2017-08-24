public class Solution {
  public int missing(int[] array) {
    // write your solution here
    int n = array.length;
    if (n == 0) {
      return 1;
    }
    int i = 0, j = n - 1;
    while (i < j) {
      int mid = i + (j - i) / 2;
      int diff = array[mid] - mid;
      if (diff == 1) {
        i = i + 1;
      } else { // diff = 2
        j = mid;
      }
    }
    return array[n - 1] == n ? n + 1 : array[j] - 1;
  }
}
