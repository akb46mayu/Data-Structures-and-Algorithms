//
public class Solution {
  public int closest(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    } 
    int left = 0, right = array.length - 1;
    while (left + 1 < right){
      int mid = left + (right - left) / 2;
      if (target == array[mid]) {
        return mid;
      } else if (target > array[mid]) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (Math.abs(array[left] - target) <  Math.abs(array[right] - target)){
      return left;
    } else{
      return right;
    }
  }
}
