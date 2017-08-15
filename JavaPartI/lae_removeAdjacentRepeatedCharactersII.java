// compare with the previous element
public class Solution {
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    int i = 0, count = 1, n = input.length();
    for (int j = 1; j < n; j++) {
      if (arr[j] != arr[j - 1]) {
        arr[++i] = arr[j];
        count = 1;
      } else {
        while (j < n && arr[j] == arr[j - 1]) {
          count++;
          if (count == 2) {
            arr[++i] = arr[j];
          }
          j++;
        }
        j--;
      }
    }
    return new String(arr, 0, i + 1);
  }
}


/// ta class solution, compare with the 'res'
public class Solution {
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() <= 2) {
      return input;
    }
    int i = 1, n = input.length();
    char[] arr = input.toCharArray();
    for (int j = 2; j < n; j++) {
      if (arr[j] != arr[i - 1]) {
        arr[++i] = arr[j];
      }
    }
    return new String(arr, 0, i + 1);
  }
}
