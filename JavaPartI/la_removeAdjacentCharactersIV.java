public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1 ) {
      return input;
    }
    int end = 0;
    int j = 1;
    char[] arr = input.toCharArray();
    while (j < input.length()) {
      if (end == -1 || arr[end] != arr[j]) {
        arr[++end] = arr[j];
      } else {
          end--;
          while(j < input.length() - 1 && arr[j] == arr[j+1]) {
            j++;
          }
      }
      j++;
    }
    return new String(arr, 0, end + 1);
  }
}
