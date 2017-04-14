class Pair {
  public int row, col, val;
  public Pair(int row, int col, int val) {
    this.row = row;
    this.col = col;
    this.val = val;
  }
}

class PairComparator implements Comparator<Pair> {
  public int compare(Pair a, Pair b){
    return a.val - b.val;
  }
}

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here.
    
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new PairComparator());
    int m = matrix.length, n = matrix[0].length;
    boolean[][] hash = new boolean[m][n];
    pq.offer(new Pair(0, 0, matrix[0][0]));
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    for (int i = 0; i < k - 1; i++) {
      Pair cur = pq.poll();
      for (int j = 0; j < 2; j++) {
        int nrow = cur.row + dx[j];
        int ncol = cur.col + dy[j];
        if (nrow < m && ncol < n && !hash[nrow][ncol]) {
          hash[nrow][ncol] = true;
          pq.offer(new Pair(nrow, ncol, matrix[nrow][ncol]));
        }
      }
    }
    return pq.poll().val;
  }
}
