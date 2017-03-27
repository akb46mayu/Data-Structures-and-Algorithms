//

public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0){
      return 1;
    }
    if (a == 0){
      return 0;
    }
    long half = power(a, b / 2);
    return b % 2 == 0 ? half * half: a * half * half;
  }
}
