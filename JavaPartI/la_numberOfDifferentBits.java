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


////
public class Solution {
  public int diffBits(int a, int b) {
    // Write your solution here.
    int c = a ^ b;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (c & 1);
      c >>= 1;
    }
    return count;
  }
}
