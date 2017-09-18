// XOR operation
public class Solution {
  public int missing(int[] array) {
    // Write your solution here.
    int result = 0;
    int n = array.length + 1;
    for (int i : array) {
      result ^= i;
    }
    for (int j = 1; j <= n; j ++) {
      result ^= j;
    }
    return result;
  }
}
/////////// hashtable
public class Solution2 {
  public int missing(int[] array) {
    //
    HashSet<Integer> hash = new HashSet<Integer>();
    for (int i : array) {
      hash.add(i);
    }
    for (int j = 1; j <= array.length + 1; j++) {
      if (!hash.contains(j)) { 
        return j;
      } 
    }
    return -1;
  }
}
//////////////////////////////////////////////
// leet code ver
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n  / 2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }
}
