public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<>();
    int n = array.length;
    Arrays.sort(array);
    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {  // remove dups for the 1st member
          continue;
      }
      int left = i + 1, right = n - 1;
      while (left < right) {
        int subsum = array[left] + array[right];
        if (subsum == target - array[i]) {
          res.add(Arrays.asList(array[i], array[left], array[right]));
          left++; // without this line, you will get infinite loop
          while (left < right && array[left] == array[left - 1]) {
            left++;
          }
        } else if (subsum < target - array[i]) {
          left++;
        } else { 
          right--;
        }
      }
    }
    return res;
  }
}

//// mehtod 2
public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n = array.length;
    Arrays.sort(array);
    for(int i = 0; i < n - 2; i++) {
      if (!set.contains(array[i])) {
        set.add(array[i]);
        int tar = target - array[i];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = i + 1; j < n; j++) {
          Integer count = map.get(tar - array[j]);
          if (count != null) {
            if (count == 1) {
              res.add(Arrays.asList(array[i], tar - array[j], array[j]));
              map.put( tar - array[j], count - 1);
              map.put(array[j], 0);
            }
          } else {
            map.put(array[j], 1);
          }
        }
      } 
    }
    return res;
  }
}
