class Cell {
  int x, y, l;
  Cell(int x, int y, int l) {
    this.x = x;
    this.y = y;
    this.l = l;
  }
}

class MyComparator implements Comparator<Cell> {
  public int compare(Cell o1, Cell o2) {
    if (o1.l == o2.l) {
      return 0;
    } else {
      return o1.l < o2.l ? -1 : 1;
    }
  }
}

public class Solution {
  public int maxTrapped(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    if (m <= 2 && n <= 2) {
      return 0;
    }
    PriorityQueue<Cell> pq = new PriorityQueue<>(1, new MyComparator());
    int[][] visit = new int[m][n];
    int res = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    // border
    for (int i = 0; i < m; i++) {
      visit[i][0] = 1;
      visit[i][n - 1] = 1;
      pq.offer(new Cell(i, 0, matrix[i][0]));
      pq.offer(new Cell(i, n - 1, matrix[i][n - 1]));
    }
    for (int j = 1; j < n - 1; j++) {
      visit[0][j] = 1;
      visit[m - 1][j] = 1;
      pq.offer(new Cell(0, j, matrix[0][j]));
      pq.offer(new Cell(m - 1, j, matrix[m - 1][j]));
    }
    //
    while (!pq.isEmpty()) {
      Cell cur = pq.poll();
      int newx = 0, newy = 0;
      for (int i = 0; i < 4; i++) {
        newx = cur.x + dx[i];
        newy = cur.y + dy[i];
        if (newx >= 0 && newx < m && newy >= 0 && newy < n && visit[newx][newy] == 0) {
          int curlevel = Math.max(matrix[newx][newy], cur.l);
          res += Math.max(0, curlevel - matrix[newx][newy]);
          pq.offer(new Cell(newx, newy, curlevel));
          visit[newx][newy] = 1;
        }
      }
    }
    return res;
  }
}
//// ------- this is way two logic

public class Solution {
  public int maxTrapped(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    Queue<Cell> pq = new PriorityQueue<>(1, new MyComparator());
    boolean[][] visit = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
          pq.offer(new Cell(i, j, matrix[i][j]));
          visit[i][j] = true;
        }
      }
    }
    //
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int nx, ny;
    int res = 0;
    while(!pq.isEmpty()) {
      Cell temp = pq.poll();
      int x = temp.x, y = temp.y, l = temp.l;
      res += Math.max(l - matrix[x][y], 0);
      visit[x][y] = true;
      for(int k = 0; k < 4; k++) {
        nx = x + dx[k];
        ny = y + dy[k];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && visit[nx][ny] == false) {
          pq.offer(new Cell(nx, ny, Math.max(matrix[nx][ny], l)));
          visit[nx][ny] = true;
        }
      }
    }
    return res;
  }
}
