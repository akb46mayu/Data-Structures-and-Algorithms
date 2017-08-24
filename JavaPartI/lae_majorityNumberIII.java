
public class Solution {
  public List<Integer> majority(int[] array, int k) {
    // write your solution here
    Map<Integer, Integer> hmap = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    int n = array.length;
    for (int i : array) {
      Integer count = hmap.get(i);
      if (count != null) {
        hmap.put(i, count + 1);
      } else {
        hmap.put(i, 1);
      }
    }
    for (int j : hmap.keySet()) {
      if (hmap.get(j) > n / k) {
        res.add(j);
      }
    }
    return res;
  }
}
