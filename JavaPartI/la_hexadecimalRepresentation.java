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
//// way2
public class Solution {
  public String hex(int number) {
    // Write your solution here.
    StringBuilder sb = new StringBuilder();
    if (number == 0) {
      sb.append("0");
    }
    while (number >= 1) {
      int quo = number % 16;
      if (quo <= 9) {
        sb.append((char)(quo + '0'));
      } else {
        sb.append((char)('A' + quo - 10));
      }
      number = number >> 4;
    }
    sb.append("x0");
    return sb.reverse().toString();
  }
}
