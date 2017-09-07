
public class Solution {
  public int kth(int k) {
    // write your solution here
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue();
    pq.offer(1);
    set.add(1);
    while (k > 1) {
      int temp = pq.poll();
      if (!set.contains(2 * temp)) {
        pq.offer(2 * temp);
        set.add(2 * temp);
      }
      if (!set.contains(3 * temp)) {
        pq.offer(3 * temp);
        set.add(3 * temp);
      }
      k--;
    }
    return  pq.poll();
  }
}
