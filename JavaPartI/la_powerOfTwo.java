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

/////  with bit operations, count the number of ones
public class Solution2 {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here.
    if (number <= 0) {
      return false;
    }
    int count = 0;
    while (number > 0) {
      count += (number & 1);
      number >>= 1;
      if (count == 2) {
        return false;
      }
    }
    return true;
  }
}
