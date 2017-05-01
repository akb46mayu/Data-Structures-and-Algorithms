public class Solution {
  public int diffBits(int a, int b) {
    // Write your solution here.
    int res = a ^ b;
    int count = 0;
    while (res != 0) {
      count += (res & 1);
      res >>>= 1;
    } 
    return count;
  }
}
