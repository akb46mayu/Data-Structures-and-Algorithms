public class Solution {
  public int longest(String input) {
    // Write your solution here.
    int start = 0, end = 0;
    int maxlength = 0;
    Set<Character> hashset = new HashSet<Character>();
    while (end < input.length()) {
      if (hashset.contains(input.charAt(end))) {
        hashset.remove(input.charAt(start++));
      } else {
        hashset.add(input.charAt(end++));
        maxlength = Math.max(maxlength, end - start);
      }
    }
    return maxlength;
  }
}
