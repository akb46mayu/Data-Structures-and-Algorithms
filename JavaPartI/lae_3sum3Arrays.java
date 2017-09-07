public class Solution {
  public boolean exist(int[] a, int[] b, int[] c, int target) {
    // write your solution here
    for (int elec : c) {
      int curtar = target - elec;
      Set<Integer> set = new HashSet<>();
      for (int eleb : b) {
        set.add(curtar - eleb);
      }
      for (int elea : a) {
        if (set.contains(elea)) {
          return true;
        }
      }
    }
    return false;
  }
}
