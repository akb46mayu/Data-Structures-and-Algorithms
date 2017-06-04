public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the smallest number.
    if (array.length == 1) {
      return new int[] {array[0], array[0]};
    }
    int n = array.length;
    int left = 0, right = n - 1;
    while (left < right) {
      if (array[left] < array[right]) {
        swap(array, left, right);
      }
      left++;
      right--;
    }
    return new int[]{findLarge(array, 0, (n - 1)/ 2), findSmall(array, n / 2, n - 1)};
  }
  private int findLarge(int[] array, int left, int right) {
    int maxval = array[left];
    for (int i = left + 1; i <= right; i++) {
      if (array[i] > maxval) {
        maxval = array[i];
      }
    }
    return maxval;
  }
  
  private int findSmall(int[] array, int left, int right) {
    int minval = array[left];
    for (int i = left + 1; i <= right; i++) {
      if (array[i] < minval) {
        minval = array[i];
      }
    }
    return minval;
  }
  
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
  
}
