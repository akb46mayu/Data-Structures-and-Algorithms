//
// j: current pointer , i (inclusive) pointer about the most non duplicated region.
public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    int n = input.length();
    char[] arr = input.toCharArray();
    int i = 0;
    for (int j = 1; j < n; j++) {
      if (arr[j] != arr[j - 1]) {
        arr[++i] = arr[j]; 
      }
    }
    return new String(arr, 0, i + 1);// i + 1 total number of elements, do not forget to add "new"
  } 
}
