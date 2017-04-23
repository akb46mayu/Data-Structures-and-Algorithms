
public class Solution {
  public int totalOccurrence(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int start = -1, end = - 1; 
    int left = 0, right = array.length - 1;
    // search the 1st pos of target.
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (target == array[mid]) {
        if (mid == 0 || array[mid] != array[mid - 1]) {
          start = mid;
          break;
        } else {
          right = mid - 1;
        }
      } else if (target < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (start == -1) {
      return 0;
    }
    // search the last pos of target
    left = 0;
    right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (target == array[mid]) {
        if (mid == array.length - 1 || array[mid + 1] != array[mid]) {
          end = mid;
          break;
        } else {
          left = mid + 1;
        }
      } else if (target < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    //
    return end - start + 1;
  }
}
