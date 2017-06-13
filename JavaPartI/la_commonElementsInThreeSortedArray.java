public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here.
    List<Integer> res = new ArrayList<Integer>();
    int ai = 0, bi = 0, ci = 0;
    while (ai < a.length && bi < b.length && ci < c.length) {
      if (a[ai] == b[bi] && b[bi] == c[ci]) {
        res.add(a[ai]);
        ai++;
        bi++;
        ci++;
      } else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
        ai++;
      } else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
        bi++;
      } else {
        ci++;
      }
    }
    return res;
  }
}
