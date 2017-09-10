// way 1 check after poped form the queue
public class Solution {
  public int minJump(int[] array, int index) {
    // write your solution here
    Queue<Integer> q = new LinkedList<>(); // save idx
    int n = array.length;
    if (n == 1) {
      return 0;
    }
    q.offer(index);
    int[] visit = new int[n];
    visit[index] = 1;
    int level = 0;
    while (!q.isEmpty()) {
      int qsize = q.size();
      for (int i = 0; i < qsize; i++) {
        int pos = q.poll();
        if (pos == n - 1) {
          return level;
        }
        // traverse neigh
        int start = Math.max(0, pos - array[pos]);
        int end = Math.min(n - 1, pos + array[pos]);
        for (int j = start; j <= end; j++) {
          if (visit[j] == 0) {
            q.offer(j);
            visit[j] = 1;
          }
        }
      }
      level++;
    }
    return -1;
  }
}
//// way 2 check before add it into the q

public class Solution {
  public int minJump(int[] array, int index) {
    // write your solution here
    Queue<Integer> q = new LinkedList<>(); // save idx
    int n = array.length;
    if (n == 1) {
      return 0;
    }
    q.offer(index);
    int[] visit = new int[n];
    visit[index] = 1;
    int level = 0;
    if (index == n - 1) {
      return level;
    }
    while (!q.isEmpty()) {
      int qsize = q.size();
      level++;
      for (int i = 0; i < qsize; i++) {
        int pos = q.poll();
        // traverse neigh
        int start = Math.max(0, pos - array[pos]);
        int end = Math.min(n - 1, pos + array[pos]);
        for (int j = start; j <= end; j++) {
          if (visit[j] == 0) {
            if (j == n - 1) {
              return level;
            }
            q.offer(j);
            visit[j] = 1;
          }
        }
      }
    }
    return -1;
  }
}
