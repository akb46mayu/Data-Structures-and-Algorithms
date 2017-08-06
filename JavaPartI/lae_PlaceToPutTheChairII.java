// mathematical solution
public class Solution {
  public List<Integer> putChair(char[][] gym) {
    // write your solution here
    int m = gym.length, n = gym[0].length;
    List<Integer> xdirec = new ArrayList<>();
    List<Integer> ydirec = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'E') {
          xdirec.add(i);
          ydirec.add(j);
        }
      }
    }
    res.add(getPos(xdirec, 0));
    res.add(getPos(ydirec, 1));
    return res;
  }
  
  private int getPos(List<Integer> dlist, int direc) {
    // direc 0 : x direc
    if (direc == 1) {
        Collections.sort(dlist);
    }
    int n = dlist.size();
    return dlist.get(n / 2);
  } 
}
// solution 2: bfs
class Pair {
  int x;
  int y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Solution2 {
  public List<Integer> putChair(char[][] gym) {
    // write your solution here
    int m = gym.length, n = gym[0].length;
    int[][] cost = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'E') {
          getPos(gym, cost, i, j);
        }
      }
    }
    //
    List<Integer> res = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (cost[i][j] < min) {
          min = cost[i][j];
          res = Arrays.asList(i, j);
        }
      }
    }
    return res;
  }
  
  private void getPos(char[][] gym, int[][] cost, int i, int j) {
    int m = gym.length, n = gym[0].length;
    int[][] visited = new int[m][n];
    Queue<Pair> q = new LinkedList<>();
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int count = -1;
    q.offer(new Pair(i, j));
    visited[i][j] = 1;
    while (!q.isEmpty()) {
      int qsize = q.size();
      count++;
      for (int p = 0; p < qsize; p++) {
        Pair temp = q.poll();
        int x = temp.x, y = temp.y;
        cost[x][y] += count;
        for (int k = 0; k < 4; k++) {
          int newx = x + dx[k], newy = y + dy[k];
          if (newx >= 0 && newx < m && newy >= 0 && newy < n && visited[newx][newy] == 0) {
            visited[newx][newy] = 1;
            q.offer(new Pair(newx, newy));
          }
        }  
      }
    }
  }
}
