public class Solution {
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here.
    return findKth(a, 0, b, 0, k);
  }
  
  private int findKth(int[] a, int as, int[] b, int bs, int k) {
    if (as >= a.length) {
      return b[bs + k - 1];
    }
    if (bs >= b.length) {
      return a[as + k - 1];
    }
    if (k == 1) {
      return Math.min(a[as], b[bs]);
    }
    int aval = as + k / 2 - 1 < a.length ? a[as + k / 2 - 1] : Integer.MAX_VALUE;
    int bval = bs + k / 2 - 1 < b.length ? b[bs + k / 2 - 1] : Integer.MAX_VALUE;
    if (aval < bval) {
      return findKth(a, as + k / 2, b, bs, k - k / 2);
    } else {
      return findKth(a, as, b, bs + k / 2, k - k / 2);
    }
  }
  
}
