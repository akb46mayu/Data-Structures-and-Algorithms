public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    int start = 0;
    char[] arr = input.toCharArray();
    reverseHelper(arr, 0, input.length() - 1);
    for (int i = 0; i < input.length(); i++) {
      if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ') ) {
    	  start = i;
      }
      if (arr[i] != ' ' && (i == input.length() - 1 || arr[i+1] == ' ')) {
    	  reverseHelper(arr, start, i);
      }
      
    }
    return new String(arr);
  }
  
  private void reverseHelper(char[] arr, int left, int right) {
    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    
  }
}
