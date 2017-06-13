public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Map<Integer, List<Integer>> hmap = new HashMap<>();
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      indices = hmap.get(target - array[i]);//
      if (indices != null) {
        for (int index : indices) {
          res.add(Arrays.asList(index, i));
        }
      }
      if (!hmap.containsKey(array[i])) {
        hmap.put(array[i], new ArrayList<Integer>());
      }
      hmap.get(array[i]).add(i);
    }
    return res;
  }
}
