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
/////
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
