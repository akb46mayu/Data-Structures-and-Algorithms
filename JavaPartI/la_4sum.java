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


///   T = O(n^3)

public class Solution2 {
  public boolean exist(int[] array, int target) {
    // Write your solution here.
    
    int n = array.length;
    int subtar = 0;
    for (int i = 0; i <= n - 4; i++) {
      for (int j = i + 1; j <= n - 3; j++) {
        subtar = target - array[i] - array[j];
        Set<Integer> hset = new HashSet<>();
        for (int k = j + 1; k <= n - 1; k++) {
          if (hset.contains(subtar - array[k])) {
            return true;
          }
          hset.add(array[k]);
        }
      }
    }
    return false;
  }
}
