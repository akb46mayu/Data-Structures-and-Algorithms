public class Solution {
  public List<Integer> common(List<Integer> a, List<Integer> b) {
    // write your solution here
    List<Integer> res = new ArrayList<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int lena = a.size(), lenb = b.size();
    if (lena == 0 || lenb == 0) {
      return res;
    }
    Set<Integer> hset = new HashSet<>();
    for (int num : a) {
      hset.add(num);
    }
    for (int num : b) {
      if (hset.contains(num)) {
        pq.offer(num);
      }
    }
    int size = pq.size();
    while (size > 0) {
      res.add(pq.poll());
      size--;
    }
    return res;
  }
}
