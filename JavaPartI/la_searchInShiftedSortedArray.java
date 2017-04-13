
public class Solution {
  public int search(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0, right = array.length - 1;
    while (left <= right ) {
      int mid = left + (right - left)/2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] >= array[left]) {
        if (target >= array[left] && target < array[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        
      } else {
        if (target > array[mid] && target <= array[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
        
      }
    }
    return -1;
  }
}
