public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return array;
    }
    int i = 0;
    for (int j = 1; j < array.length; j ++) {
      if (i == -1 || array[j] != array[i]) {
        array[++i] = array[j];
      } else {
        while(j < array.length && array[j] == array[i]) {
          j++;
        }
        j--;
        i--;
      }
    }
    return Arrays.copyOf(array, i + 1);
  }
}
