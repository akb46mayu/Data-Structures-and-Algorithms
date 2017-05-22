public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return;
    }
    for (int i = array.length - 1; i >= 1; i--) {
      int idx = (int)(Math.random() * (i + 1));
      swap(array, idx, i);
    }
  }
  
  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
