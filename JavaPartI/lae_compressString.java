
public class Solution {
  public String compress(String input) {
    // write your solution here
    int n = input.length();
    int i = 0;
    if (n <= 1) {
      return input;
    }
    char[] arr = input.toCharArray();
    int count = 1;
    for(int j = 1; j < n; j++) {
      if (arr[j - 1] != arr[j]) {
        if (count >= 2) {
           arr[++i] = (char) ('0'+ count);
        }
        arr[++i] = arr[j];
        count = 1;
      } else {
        count++;
      }
    }
    if (count >= 2) {
      arr[++i] =  (char) ('0'+ count);
    }
    return new String(arr, 0, i + 1);
  }
}
