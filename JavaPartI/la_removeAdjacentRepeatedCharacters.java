//
// j: current pointer , i (inclusive) pointer about the most non duplicated region.
public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    
    char[] arr = input.toCharArray();
    int i = 0, j = 0;
    while (j < arr.length) {
      if (arr[i] == arr[j]) {
        j++;
      } else {
        arr[++i] = arr[j++];
      }
    }
    return new String(arr, 0, i + 1);  // i + 1 total number of elements, do not forget to add "new"
  } 
}
