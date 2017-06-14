public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    int n = array.length;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (array[i] != 0) {
        swap(array, i, j);
        j++;
      } 
    }
    return array;
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
