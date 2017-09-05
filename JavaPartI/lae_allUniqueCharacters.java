public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here.
    int n = word.length();
    if (n > 26) {
      return false;
    }
    int[] dict = new int[26];
    for (char ch : word.toCharArray()) {
      if (dict[ch - 'a'] == 1) {
        return false;
      } else {
        dict[ch - 'a'] = 1;
      }
    }
    return true;
  }
}
