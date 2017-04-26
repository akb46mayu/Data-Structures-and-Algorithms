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
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray(); 
    reverseHelper(arr, 0, arr.length - 1);
    return new String(arr);
  }
  private void reverseHelper(char[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    swap(arr, left, right);
    reverseHelper(arr, left + 1, right - 1);
  }
  private void swap(char[] arr, int left, int right) {
    char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
