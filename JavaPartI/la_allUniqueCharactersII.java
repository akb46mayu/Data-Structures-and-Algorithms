public class Solution {
  public boolean allUnique(String word) {
    // write your solution here
    if (word == null || word.length() == 0) {
      return true;
    }
    int[] dict = new int[8];
    for (int i = 0; i < word.length(); i++) {
      int ch = word.charAt(i);
      int row = ch / 32;
      int col = ch % 32;
      if (((dict[row] >> col) & 1) == 1) {
        return false;
      } else {
        dict[row] |= (1<<col);
      }
    }
    return true;
  }
}
