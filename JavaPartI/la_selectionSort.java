
// way 1
public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int glbmin = i;
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[glbmin]) {
          glbmin = j;
        }
      }
      int temp = array[glbmin];
      array[glbmin] = array[i];
      array[i] = temp;
    }
    return array;
  }
}



// way 2
public class Solution2 {
  public int[] solve(int[] array) {
    // Write your solution here.
    
    if (array == null || array.length == 0) {
      return array;
    }
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int minidx = i;
      for (int j = i + 1; j < n; j ++) {
        if (array[minidx] > array[j]) {
          swap(array, i, j);
        }
      }
    }
    
    return array;
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
  
}
