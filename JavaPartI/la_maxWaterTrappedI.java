public class Solution {    // use two dp arrays with O(n) extra space, but easy to think 
  public int maxTrapped(int[] array) {
    // Write your solution here.
    int n = array.length;
    if (n <= 2) {
      return 0;
    }
    int[] dpl = new int[n];
    int[] dpr = new int[n];
    dpl[0] = array[0];
    dpr[n - 1] = array[n - 1];
    for (int i = 1; i < n; i++) {
      dpl[i] = Math.max(dpl[i - 1], array[i]);
    }
    for (int j = n - 2; j >= 0; j--) {
      dpr[j] = Math.max(dpr[j + 1], array[j]);
    }
    int maxsum = 0;
    for (int i = 1; i < n - 1; i++) {
      maxsum += Math.max(0, Math.min(dpl[i - 1], dpr[i + 1]) - array[i]);
    }
    return maxsum;
  }
}
