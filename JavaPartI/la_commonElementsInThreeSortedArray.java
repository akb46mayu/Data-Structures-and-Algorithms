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

// method 2
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here.
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int i : a) {
      Integer count = map.get(i);
      if (count == null) {
        map.put(i, 1);
      } else {
        map.put(i, count + 1);
      }
    }
    int i = 0, j = 0;
    int m = b.length, n = c.length;
    while (i < m && j < n) {
      if (b[i] == c[j]) {
        Integer count = map.get(b[i]);
        if (count != null && count >= 1) {
          map.put(b[i], count - 1);
          res.add(b[i]);
        }
        i++;
        j++;
      } else if (b[i] < c[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }
}
