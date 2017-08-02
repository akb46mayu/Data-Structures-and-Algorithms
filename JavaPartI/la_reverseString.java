public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      swap(arr, left++, right--);
    }
    return new String(arr);
  }
  private void swap(char[] arr, int left, int right) {
    char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
//// method 2, recursion

public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if(input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    revHelper(arr, 0, input.length() - 1);
    return new String(arr);
  }
  
  private void revHelper(char[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    revHelper(arr, left + 1, right - 1);
  }
}

