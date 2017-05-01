public class Solution {
  public String hex(int number) {
    // Write your solution here.
    String prefix = "0x";
    if (number == 0) {
      return "0x0";
    }
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      int temp = number % 16;
      if (temp < 10) {
        sb.append((char)(temp + '0'));
      } else {
        sb.append((char)(temp - 10 + 'A'));
      }
      number >>= 4;
    }
    return prefix + sb.reverse().toString();
  }
}
