public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array.length == 0 || array.length == 1) {
      return array;
    }
    int i = 0;
    for (int j = 1; j < array.length; j++) {
      if (array[j] != array[j - 1]) {
        array[++i] = array[j];
      }
    }
    return Arrays.copyOf(array, i + 1);
  }
}
