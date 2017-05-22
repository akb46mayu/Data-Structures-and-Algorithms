public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while(true) {
      int num = 0;
      for (int i = 0; i < 5; i++) {
        num = 5 * num + RandomFive.random5();
      }
      if (num < 3000) {
        return num % 1000;
      }
    }
  }
}
