public class Solution {
  public boolean existSum(int[] array, int target) {
    // Write your solution here.
    Set<Integer> hset = new HashSet<Integer>();
    for (int i = 0; i < array.length; i++) {
      if (hset.contains(array[i])) {
        return true;
      }
      hset.add(target - array[i]);
    }
    return false;
  }
}
