public class Solution {
  public int[] rainbowSortII(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return array;
    }
    int n = array.length;
    int i = 0, j = 0, k = n - 1, l = n - 1;
    while (j <= k) {
      if (array[j] == 0) {
        swap(array, i++, j++);
      } else if (array[j] == 3) {
        swap(array, j, l--);
      } else if (array[j] == 2) {
        swap(array, j, k--);
      } else {
        j++;
      }
      if (l < k) {
        k--;
      }
    }
    return array;
  }
  
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
