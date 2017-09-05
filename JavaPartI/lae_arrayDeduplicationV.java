public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    int n = array.length;
    if (n <= 2) {
      return array;
    }
    int count = 1;
    int i = 0; 
    for (int j = 1; j < n; j++) {
      if (array[j] == array[j - 1]) {
        count++;
        if (count <= 2) {
          array[++i] = array[j];
        }
      } else {
        count = 1;
        array[++i] = array[j];
      }
    }
    return Arrays.copyOf(array, i + 1);
  }
}
