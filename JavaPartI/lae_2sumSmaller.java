public class Solution {
  public int smallerPairs(int[] array, int target) {
    // write your solution here
    Arrays.sort(array);
    int n = array.length;
    int i = 0, j = n - 1;
    int count = 0;
    while (i < j) {
      int sum = array[i] + array[j];
      if (sum < target) {
        count += j - i;
        i++;
      } else {
        j--;
      }
    }
    return count;
  }
}
