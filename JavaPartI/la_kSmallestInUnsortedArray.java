public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    int[] result = new int[k];
    if (array.length == 0 || k == 0) {
      return result;
    }
    PriorityQueue<Integer> pq= new PriorityQueue<Integer>(k, new
       Comparator<Integer>() {
         public int compare(Integer o1, Integer o2) {
           if (o1.equals(o2)) {
             return 0;
           }
           return o1 > o2? -1: 1;
         }
       }
    );
    for (int i = 0; i < k; i++) {
      pq.offer(array[i]);
    }
    int n = array.length;
    for (int i = k; i < n; i++) {
      if (array[i] < pq.peek()) {
        pq.poll();
        pq.offer(array[i]);
      }
    }
    for (int i = k - 1;  i>=0; i--) {
      result[i] = pq.poll();
    }
    return result;
  }
}
