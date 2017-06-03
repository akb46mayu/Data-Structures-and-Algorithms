public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return array;
    }
    int j = 0;
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] == array[i -1]) {
        count++;
        if (count <= 2) {
          array[++j] = array[i];
        }
      } else {
        count = 1;
        array[++j] = array[i];
      }
    }
    return Arrays.copyOf(array, j + 1);
  }
}
