public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    //write your solution here
    int lena = A.size(), lenb = B.size();
    List<Integer> res = new LinkedList();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int a : A) {
      Integer count = hmap.get(a);
      if (count != null) {
        hmap.put(a, count + 1);
      } else {
        hmap.put(a, 1);
      }
    }
    for (int b : B) {
      Integer count = hmap.get(b);
      if (count != null) {
        hmap.put(b, count - 1);
        if (count >= 0) {
          pq.offer(b);
        }
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
