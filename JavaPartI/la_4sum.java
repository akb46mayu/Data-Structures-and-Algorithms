// use hash, and two pairs' sum,     i0,j0    i1,j1  j0 < i1 can give us such solution   
// assume the array has been sorted!!

public class Solution {
  public boolean exist(int[] array, int target) {
    // Write your solution here.
    int n = array.length;
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int j = 1; j < n; j++) {
      for (int i = 0; i < j; i++) {
        int pairsum = array[i] + array[j];
        if (hmap.containsKey(target - pairsum) && hmap.get(target - pairsum) < i) {
          return true;
        }
        if (!hmap.containsKey(pairsum)) {
          hmap.put(pairsum, j);
        }
      }
    }
    return false;
  }
}
