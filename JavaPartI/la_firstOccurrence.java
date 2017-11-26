//
public class Solution {
  public int firstOccur(int[] array, int target) {
    // Write your solution here
    if (array == null){
      return -1;
    }
    int left = 0, right = array.length - 1;
    while (left <= right){
      int mid = left + (right - left)/2;
      if (array[mid] == target){
         if (mid == 0 || array[mid-1] < array[mid]){
           return mid;
         }else{
           right = mid - 1;
         }
      } else if (array[mid] < target){
          left = mid + 1;
      } else{
          right = mid - 1;
      }    
    } 
    return -1;
  }
}
