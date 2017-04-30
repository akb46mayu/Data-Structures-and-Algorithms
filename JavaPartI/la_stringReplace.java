public class Solution {
  public String replace(String input, String s, String t) {
    // Write your solution here.
    int startIdx = 0;
    int matchIdx = input.indexOf(s, startIdx);
    StringBuilder sb = new StringBuilder();
    while (matchIdx != -1) {
      sb.append(input, startIdx, matchIdx).append(t);
      startIdx = matchIdx + s.length();
      matchIdx = input.indexOf(s, startIdx);
    }
    sb.append(input, startIdx, input.length());
    return sb.toString();
  }
}
