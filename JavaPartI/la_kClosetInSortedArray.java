public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array == null || array.length == 0){
      return array; 
    }
    if (k == 0){
      return new int[]{};
    }
    int[] out = new int[k];
    int idx = findIdx(array, target);
    
    int left = idx, right = idx, count = 0;
    out[0] = array[idx];
    while (right - left + 1 < k){  // code inside the while loop can be simplified
      if (left == 0){
        out[++count] = array[++right];
      } else if (right == array.length -1 ){
        out[++count] = array[--left];
      } else if ( Math.abs(array[left - 1] - target)  <= Math.abs(array[right + 1] - target)){
        out[++count] = array[--left];
      } else{
        out[++count] = array[++right];
      }
    }
    return out;
  }
  
  private int findIdx(int[] array, int target){
    int left = 0, right = array.length - 1;
    while (left + 1 < right){
      int mid = left + (right - left)/2;
      if (target <= array[mid]){
        right = mid;
      } else{
        left = mid;
      }
    }
    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)){
      return left;
    } else {
      return right;
    }
  }
}
