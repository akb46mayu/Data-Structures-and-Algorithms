public class Solution {
  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;
  public Solution() {
    // add new fields and complete the constructor if necessary.
    maxHeap = new PriorityQueue<>(1, Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }
  
  public void read(int value) {
    // write your implementation here.
    if (maxHeap.isEmpty() || value <= maxHeap.peek()) { // value < maxheap.peek is also ok
      maxHeap.offer(value);
    } else {
      minHeap.offer(value);
    }
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    } else if (maxHeap.size() >= minHeap.size() + 2) {
      minHeap.offer(maxHeap.poll());
    }
  }
  
  public Double median() {
    // write your implementation here.
    int tsize = minHeap.size() + maxHeap.size();
    if (tsize == 0) {
      return null;
    } else if (tsize % 2 == 1) {
      return (double) maxHeap.peek();
    } else {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }
  
}
