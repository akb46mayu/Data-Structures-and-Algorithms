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
          left++;
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
