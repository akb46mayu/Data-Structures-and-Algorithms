public class Solution {
  public String decompress(String input) {
    // Write your solution here.
    int n = input.length();
    if (n == 0) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    char cur = input.charAt(0);
    sb.append(cur);  
    int count = 0;
    for (int i = 1; i <= n - 1; i++) {
      char ch = input.charAt(i);
      if (isNum(ch)) {
        count = ch - '0';
        for (int j = 0; j < count - 1; j++) {
          sb.append(cur);
        }
      } else {
        cur = ch;
        sb.append(ch);
      }
    }
    return sb.toString();
  }
  
  private boolean isNum(char ch) {
    if (ch - '2' >= 0 && ch - '2' <= 9) {
      return true;
    }
    return false;
  }
}
