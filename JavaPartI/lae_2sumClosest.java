
public class Solution {
  public List<Integer> closest(int[] array, int target) {
    // write your solution here
    List<Integer> res = new ArrayList<>();
    int n = array.length;
    Arrays.sort(array);
    if (n == 2) {
      res.add(array[0]);
      res.add(array[1]);
      return res;
    }
    int i = 0, j = n - 1;
    int a = 0, b = 0;
    int mindiff = Integer.MAX_VALUE;
    while (i < j) {
      int sum = array[i] + array[j];
      int curdiff = Math.abs(sum - target);
      if (curdiff < mindiff) {
        mindiff = curdiff;
        a = array[i];
        b = array[j];
      }
      if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    res.add(a);
    res.add(b);
    return res;
  }
}
