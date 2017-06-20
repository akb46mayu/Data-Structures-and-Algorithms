public class Solution {
  public long kth(int k) {
    // Write your solution here.
    Set<Long> hset = new HashSet<Long>();
    PriorityQueue<Long> pq = new PriorityQueue<>();
    pq.offer(3 * 5 * 7L);
    hset.add(3 * 5 * 7L);
    while (k > 1) {
      Long popedEle = pq.poll();
      if (hset.add(3 * popedEle)) {
        pq.offer(3 * popedEle);
      }
      if (hset.add(5 * popedEle)) {
        pq.offer(5 * popedEle);
      }
      if (hset.add(7 * popedEle)) {
        pq.offer(7 * popedEle);
      }
      k--;
    }
    return pq.peek();
  }
}

