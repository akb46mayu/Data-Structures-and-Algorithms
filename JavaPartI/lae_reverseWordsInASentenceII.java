public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
    int n = input.length();
    int i = 0;
    char[] arr = input.toCharArray();
    for (int j = 0; j < n; j++) {
      if (arr[j] == ' ' && (j == 0 || arr[j - 1] == ' ')) {
        continue;
      }
      arr[i++] = arr[j];
    }
    if (i >= 1 && arr[i - 1] == ' ') {
      i--;
    } 
    arr = Arrays.copyOf(arr, i);
    //
    int m = arr.length;
    reverse(arr, 0, m - 1);
    i = 0;
    
    for (int j = 0; j < m; j++) {
      if (j == 0 || (arr[j] != ' ' && arr[j - 1] == ' ')) {
        i = j; 
      } 
      if (j == m - 1 || (arr[j + 1] == ' ' && arr[j] != ' ')) {
        reverse(arr, i, j);
      }
    }
    return new String(arr);
  }
  
  private void reverse(char[] arr, int i, int j) {
    while (i < j) {
      char ch = arr[i];
      arr[i] = arr[j];
      arr[j] = ch;
      i++;
      j--;
    }
  }
}
