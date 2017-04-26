public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    int m = input.length();
    n = n % m;
    reverse(arr, 0, m - n - 1);
    reverse(arr, m - n, m - 1);
    reverse(arr, 0 , m - 1);
    return new String(arr);
    
  }
  
  private void reverse(char[] arr, int left, int right) {
    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }
}
