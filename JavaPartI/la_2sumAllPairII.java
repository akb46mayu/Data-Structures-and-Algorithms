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
