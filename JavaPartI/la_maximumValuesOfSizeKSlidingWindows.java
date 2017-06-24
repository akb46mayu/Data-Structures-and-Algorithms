public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here.
    List<Integer> res = new ArrayList<Integer>();
    Deque<Integer> dq = new LinkedList<Integer>();
    int n = array.length;
    for (int i = 0; i < n; i++) {
      while (!dq.isEmpty() && array[i] >= array[dq.peekLast()]) {
        dq.pollLast();
      }
      if (!dq.isEmpty() && dq.peekFirst() <= (i - k) ) {
        dq.pollFirst();
      }
      dq.offer(i);
      if (i >= k - 1) {
        res.add(array[dq.peekFirst()]);
      }
    }
    return res;
  }
}
