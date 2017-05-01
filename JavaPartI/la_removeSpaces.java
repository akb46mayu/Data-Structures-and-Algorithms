public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    int n = input.length();
    int end = 0;
    for (int j = 0; j < n; j++) {
      if (arr[j] == ' ' && (j == 0 || arr[j - 1] == ' ')) {
        continue;
      }
      arr[end++] = arr[j];
    }
    if (end >= 1 && arr[end - 1] == ' ') {
      return new String(arr, 0, end - 1);
    }
    return new String(arr, 0, end);
  }
}
