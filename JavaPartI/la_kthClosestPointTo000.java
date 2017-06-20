public class Solution {
  
   public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    // Write your solution here.
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
      public int compare(List<Integer> o1, List<Integer> o2) {
        long l1 = computeDist(o1, a, b, c);
        long l2 = computeDist(o2, a, b, c);
        if (l1 == l2) {
          return 0;
        } else {
          return l1 < l2 ? -1 : 1;
        } 
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0, 0);
    pq.offer(cur);
    visited.add(cur);
    while (k > 0) {
      cur = pq.poll();
      List<Integer> tpoint = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (visited.add(tpoint) && tpoint.get(0) < a.length) {
        pq.offer(tpoint);
      }
      tpoint = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (visited.add(tpoint) && tpoint.get(1) < b.length) {
        pq.offer(tpoint);
      }
      tpoint = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (visited.add(tpoint) && tpoint.get(2) < c.length) {
        pq.offer(tpoint);
      }
      k--;
    }
    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);
    return cur;
  }
  
  private long computeDist(List<Integer> point, int[] a, int[] b, int[] c) {
    long dist = 0;
    dist += a[point.get(0)] * a[point.get(0)];
    dist += b[point.get(1)] * b[point.get(1)];
    dist += c[point.get(2)] * c[point.get(2)];
    return dist;
  } 
}
