public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return array;
    }
    int i = 0;
    for (int j = 1; j < array.length; j ++) {
      if (i == -1 || array[j] != array[i]) {
        array[++i] = array[j];
      } else {
        while(j < array.length && array[j] == array[i]) {
          j++;
        }
        j--;
        i--;
      }
    }
    return Arrays.copyOf(array, i + 1);
  }
}

/// diff logic 

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    int n = array.length;
    if(n <= 1) {
      return array;
    }
    int i = 0;
    for(int j = 1; j < n; j++) {
      if(array[j] != array[j - 1]) {
      	array[++i] = array[j];
      } else {
        while(j < n && array[j] == array[j - 1]) {
          j++;
        }
        j--;
        i--;
      }
    }
    return Arrays.copyOf(array, i + 1);
  }
}
