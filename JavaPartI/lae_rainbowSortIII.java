public class Solution {
  public int[] rainbowSortIII(int[] array, int k) {
    // Write your solution here.
    int n = array.length;
    if (n == 0) {
      return array;
    }
    int[] count = new int[k + 1];
    for (int val : array) {
      count[val]++;
    }
    int z = 0;
    for (int j = 1; j <= k; j++) {
      int num = count[j];
      for (int i = 0; i < num; i++) {
        array[z++] = j;
      }
    }
    
    return array;
  }
}
