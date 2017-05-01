public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here.
    if (number <= 0) {
      return false;
    }
    while (number / 2 != 0) {
      if (number % 2 == 1) {
        return false;
      }
      number /= 2;
    }
    return true;
  }
}
