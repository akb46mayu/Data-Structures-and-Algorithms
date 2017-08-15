import java.util.*; // headers MUST be above the first class

public class Solution {
  public int findMax(int[] arr, int tar) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    int i = 0;
    int j = arr.length - 1;
    while (i + 1 < j) {
      int mid = i + (j - i) / 2;
      
      if (arr[mid] >= tar) {
        j = mid - 1;
      } else {
        i = mid;
      }
    }
    if (arr[j] < tar) {
      return arr[j];
    }
    if (arr[i] < tar) {
      return arr[i];
    }
    return -1;
    
  }
  
  public static void main(String[] args) {
  	Solution sol = new Solution();
    int[] arr = {2,3,4,5,6,7};
    int tar = 6;
    int res = sol.findMax(arr, tar);
    System.out.println(res);
    
    
    tar = 10;
    res = sol.findMax(arr, tar);
    System.out.println(res);
    

    tar = 2;
    res = sol.findMax(arr, tar);
    System.out.println(res);
  }
}
