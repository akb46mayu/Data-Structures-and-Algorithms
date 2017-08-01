
public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return array;
    }
    int i = 0, n = array.length;
    for (int j = 0; j < n; j++) {
      if (array[j] != 0) {
        swap(array, i++, j);
      }
    }
    return array;
  }  
  
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
