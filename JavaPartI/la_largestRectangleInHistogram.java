public class Solution {
  public int largest(int[] array) {
    // Write your solution here.
    Deque<Integer> stack = new LinkedList<Integer>();
    int res = 0;
    int n = array.length;
    for (int i = 0; i <= n; i++) {
      int curh = (i == n ? 0 : array[i]);
      while (!stack.isEmpty() && array[stack.peekFirst()] > curh) {  // >- curh also works
        int height = array[stack.pollFirst()];
        int left = (stack.isEmpty() ? -1 : stack.peekFirst());
        res = Math.max(res, (i - left - 1) * height);
      }
      stack.offerFirst(i);
    }
    return res;
  }
}
