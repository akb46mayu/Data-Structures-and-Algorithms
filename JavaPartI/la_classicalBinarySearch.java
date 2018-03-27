public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here.
    if (array == null){
      return -1;
    }
    int left = 0, right = array.length - 1;
    while (left <= right){
      int mid = left + (right - left)/2;
      if (target == array[mid]){
        return mid;
      }else if (target < array[mid]){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }
    
    return -1;
  }
}
