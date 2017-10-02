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

/// method 2: with pq 
class Pair {
  int val;
  int idx;
  Pair(int val, int idx) {
    this.val = val;
    this.idx = idx;
  }
}

class MyComparator implements Comparator<Pair> {
  public int compare(Pair o1, Pair o2) {
    if (o1.val == o2.val) {
      return 0;
    }
    return o2.val < o1.val ? -1 : 1;
  }
}
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here.
    Queue<Pair> pq = new PriorityQueue<>(1, new MyComparator());
    List<Integer> res = new ArrayList<>();
    int n = array.length;
    for (int i = 0; i < n; i++) {  // i is the right idx of the sliding window
      if (i < k) {
        pq.offer(new Pair(array[i], i));
        if (i == k - 1) {
            res.add(pq.peek().val);
        }
        continue;
      }
      Pair temp = pq.peek();
      int idx = temp.idx;
      if (idx <= i - k) {
        pq.poll();
      }
      pq.offer(new Pair(array[i], i));
      res.add(pq.peek().val);
    }
    return res;
  }
}
