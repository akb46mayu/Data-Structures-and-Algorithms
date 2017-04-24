class Pair {
  int row;
  int col;
  int sum;
  public Pair(int row, int col, int sum) {
    this.row = row;
    this.col = col;
    this.sum = sum;
  }
}



public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int m = A.length;
        int n = B.length;
        PriorityQueue<Pair> pqueue = new PriorityQueue<Pair> (k, new
          Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
              if (o1.sum == o2.sum) {
                return 0;
              }
              return o1.sum < o2.sum ? -1 : 1;
            }
          }
        );
        pqueue.offer(new Pair(0, 0, A[0] + B[0]));
        boolean[][] hash = new boolean[m][n];
        hash[0][0] = true;
        int[] drow = {0, 1};
        int[] dcol = {1, 0};
        int i = 0;
        while (i < k - 1) {
          Pair cur = pqueue.poll();
          for (int j = 0; j < 2; j++) {
            int newrow = drow[j] + cur.row;
            int newcol = dcol[j] + cur.col;
            if (newrow < m && newcol < n && hash[newrow][newcol] == false) {
              pqueue.offer(new Pair(newrow, newcol, A[newrow] + B[newcol]));
              hash[newrow][newcol] = true;
            }
          }
          i++;
        }
        return pqueue.poll().sum;
    }
}
