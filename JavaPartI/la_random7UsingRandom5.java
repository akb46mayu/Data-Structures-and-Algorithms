public class Solution {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while (true) {
      int val = RandomFive.random5() * 5 + RandomFive.random5();
      if (val < 21) {
        return val % 7;
      }
    }
  }
}
