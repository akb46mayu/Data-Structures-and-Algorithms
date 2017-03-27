///

public class Solution {
  public int lastOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0){
      return -1;
    }
    int left = 0, right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (target == array[mid]) {
        if (mid == array.length - 1 || array[mid] < array[mid + 1]) {
          return mid;
        } else {
          left = mid + 1;
        }
      } else if (target < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
