class Cell {
  int x;
  int y;
  int val;
  Cell(int x, int y, int val) {
    this.x = x;
    this.y = y;
    this.val = val;
  }
}

public class Solution {
  public int whiteObjects(int[][] matrix) {
    // write your solution here
    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (bfs(matrix, i, j)) {
          count++;
        }
      }
    }
    return count;
  }
  
  private boolean bfs(int[][] matrix, int i, int j) {
    if (matrix[i][j] == 2 || matrix[i][j] == 1) {
      return false;
    }
    int m = matrix.length, n = matrix[0].length;
    Queue<Cell> q = new LinkedList<>();
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    q.offer(new Cell(i, j, matrix[i][j]));
    while(!q.isEmpty()) {
      Cell temp = q.poll();
      int x = temp.x, y = temp.y;
      matrix[x][y] = 2;
      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k], ny = y + dy[k];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] == 0 ) {
          q.offer(new Cell(nx, ny, matrix[nx][ny]));
        }
      }
    }
    return true;
  }
}
