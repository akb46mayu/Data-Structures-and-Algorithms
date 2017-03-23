

public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here.
    if (array == null){
      return array;
    }
    
    int n = array.length;
    for (int i = 0; i < n; i++){
      int minval = Integer.MAX_VALUE;
      int idx = i;
      for (int j = i; j < n; j++){
        if (array[j] < minval){
          minval = array[j];
          idx = j;
        }
      }
      int temp = array[i];
      array[i] = array[idx];
      array[idx] = temp;
    }
    
    
    
    return array;
  }
}
