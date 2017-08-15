
public class Solution {
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    int n = input.length();
    char[] arr = input.toCharArray();
    int i = -1;
    for (int j = 0; j < n; j++) {
      if (i == -1 || arr[j] != arr[i]) {
        arr[++i] = arr[j];
      } else {
        while (j < n && arr[j] == arr[i]) {
          j++;
        }
        j--;
        i--;
      }
    }
    return new String(arr, 0, i + 1);
  }
}
