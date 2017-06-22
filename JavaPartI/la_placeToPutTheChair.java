class Pair {
  int x;
  int y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Solution {
  public List<Integer> putChair(char[][] gym) {
    // Write your solution here.
    int m = gym.length, n = gym[0].length;
    int[][] cost = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'E') {
          if (!updateCost(gym, cost, i, j)) {
            return null;
          }
        }
      }
    }
    List<Integer> res = null;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'C') {
          if (res == null) {
            res = Arrays.asList(i, j);
          } else if (cost[i][j] < cost[res.get(0)][res.get(1)]) {
            res.set(0, i);
            res.set(1, j);
          }
        }
      }
    }
    return res;
  }
  
  private boolean updateCost(char[][] gym, int[][] cost, int x, int y) {
    int m = gym.length, n = gym[0].length;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    Queue<Pair> queue = new LinkedList<>();
    boolean[][] visit = new boolean[m][n];
    queue.offer(new Pair(x, y));
    visit[x][y] = true;
    int newx, newy;
    int costval = 0;
    // run bfs
    while(!queue.isEmpty()) {
      costval++;
      int qsize = queue.size();
      for (int p = 0; p < qsize; p++) {
        Pair poped = queue.poll();
        int i = poped.x;
        int j = poped.y;
        for (int k = 0; k < 4; k++) {
          newx = i + dx[k];
          newy = j + dy[k];
          if (newx < m && newx >= 0 && newy < n && newy >= 0 && gym[newx][newy] != 'O' && visit[newx][newy] == false) {
            cost[newx][newy] += costval;
            visit[newx][newy] = true;
            queue.offer(new Pair(newx, newy));
          }
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visit[i][j] == false && gym[i][j] == 'E') {
          return false;
        }
      }
    }
    return true;
  }
}
