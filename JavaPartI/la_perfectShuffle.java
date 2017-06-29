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
////////
public class Solution2 {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return;
    }
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int offset = (int)(Math.random() * (n - i));
      swap(array, i + offset, i);
    }
  }
  
  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
