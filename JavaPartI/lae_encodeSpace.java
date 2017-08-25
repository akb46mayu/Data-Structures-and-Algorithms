public class Solution {
  public String encode(String input) {
    // write your solution here
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if ( ch == ' ') {
        sb.append("20%");
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
