public class Solution {
  public String decompress(String input) {
    // Write your solution here.
    char[] arr = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i++];
      int count = arr[i] - '0';
      for (int j = 0; j < count; j++) {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
