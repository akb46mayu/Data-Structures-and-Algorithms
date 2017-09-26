public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int ele : array) {
      Integer count = hmap.get(ele);
      if (count != null && count == 1 && ele * 2 == target) {
        res.add(Arrays.asList(ele, ele));
      } else if (count == null && hmap.containsKey(target - ele)){
        res.add(Arrays.asList(target - ele, ele));
      }
      if (count == null) {
        hmap.put(ele, 1);
      } else {
        hmap.put(ele, count + 1);
      }
    }
    return res;
  }
}


//// way 2: not using get's return value
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (hmap.containsKey(target - array[i])) { // update the res
        if (array[i] * 2 == target && hmap.get(array[i]) == 1) {
          res.add(Arrays.asList(array[i], array[i]));
        } else if (array[i] * 2 != target && !hmap.containsKey(array[i])) {
          res.add(Arrays.asList(target - array[i], array[i]));
        }
      }
      if (!hmap.containsKey(array[i])) {
        hmap.put(array[i], 0);
      }
      int count = hmap.get(array[i]);
      hmap.put(array[i], count + 1);
    }
    return res;
  }
}
// directly use trick]\

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here.
    Map<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    int n = array.length;
    for (int i = 0; i < n; i++) {
      Integer count = map.get(target - array[i]);
      if (count != null) {
        if (count == 1) {
          res.add(Arrays.asList(target - array[i], array[i]));
          map.put(target - array[i], count - 1);
          map.put(array[i], 0);
        }
      } else {
        map.put(array[i], 1);
      }
    }
    return res;
  }
}
