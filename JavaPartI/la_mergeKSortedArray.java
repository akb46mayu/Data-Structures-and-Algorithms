class Entry {
  int x;
  int y;
  int val;
  Entry(int x, int y, int val) {
    this.x = x;
    this.y = y;
    this.val = val;
  }
}

class MyComparator implements Comparator<Entry> {
  public int compare(Entry o1, Entry o2) {
    if (o1.val == o2.val) {
      return 0;
    }
    return o1.val < o2.val ? -1 : 1;
  }
}

public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // Write your solution here.
    
    PriorityQueue<Entry> minHeap = new  PriorityQueue<Entry>(11, new MyComparator());
    int reslen = 0;
    int cur = 0;
    // initialize the minheap from all the 0th elements, and intialize out matrix
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] arr = arrayOfArrays[i];
      reslen += arr.length;
      if (arr.length != 0) {
        minHeap.offer(new Entry(i, 0, arr[0]));
      }
    }
    int[] result = new int[reslen];
    while (!minHeap.isEmpty()) {
      Entry temp = minHeap.poll();
      int row = temp.x;
      int col = temp.y;
      result[cur++] = temp.val;
      if (col + 1 < arrayOfArrays[row].length) {
        minHeap.offer(new Entry(row, col + 1, arrayOfArrays[row][col + 1]));
      }
    }
    return result;
  }
}
