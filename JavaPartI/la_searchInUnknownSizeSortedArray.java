///

public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict == null){
      return -1;
    }
   
    int right = 1, left = 0;
    while (dict.get(right)!= null && dict.get(right) < target){
      left = right;
      right *= 2;
    }

    while (left <= right){
      int mid = left + (right - left)/2;
      if (dict.get(mid) == null || dict.get(mid) > target){
        right = mid - 1;
      } else if (dict.get(mid) < target){
        left = mid + 1;
      } else{
        return mid;
      }
    }
    return -1;
  }
}
