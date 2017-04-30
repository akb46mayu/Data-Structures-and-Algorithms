public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here.

    int n = array.length;
    if (n % 2 == 0) {
      intShuffle(array, 0, n - 1);
    } else {
      intShuffle(array, 0, n - 2);
    }
    return array;
  }
  
  private void intShuffle(int[] arr, int left, int right) {
    if ((right - left) <= 1) {
      return;
    }
    int sublen = right - left + 1;
    int m = left + sublen/2;
    int ml = left + sublen/4;
    int mr = left + sublen * 3 / 4;
    reverse(arr, ml, m - 1);
    reverse(arr, m, mr - 1);
    reverse(arr, ml, mr - 1);
    intShuffle(arr, left, left + (ml - left) * 2 - 1);
    intShuffle(arr, left + (ml - left) * 2, right);
    
  }
  
  private void reverse(int[] arr, int left, int right) {
    while (left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

}
