public class Solution {
  public int[][] maze(int n) {
    // Write your solution here.
    int[][] maze = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          maze[i][j] = 0;
        } else {
          maze[i][j] = 1;
        }
      } 
    }
    generate(maze, 0, 0);
    return maze;
  }
  
  private void generate(int[][] maze, int x, int y) {
    Dir[] dirs = Dir.values();
    shuffleDir(dirs);
    for(Dir dir : dirs) {
      int newx = dir.moveX(x, 2);
      int newy = dir.moveY(y, 2);
      if (checkVal(maze, newx, newy)) {
        maze[newx][newy] = 0;
        maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
        generate(maze, newx, newy);
      } 
    }
  }
  
  private boolean checkVal(int[][] maze, int x, int y) {
    int n = maze.length;
    return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;
  }
  
  private void shuffleDir(Dir[] dirs) {
    for (int i = 0; i < dirs.length; i++) {
      int offset = (int) (Math.random() * (dirs.length - i));
      Dir temp = dirs[i];
      dirs[i] = dirs[i + offset];
      dirs[i + offset] = temp;
    }
  }
  
  enum Dir {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
    int dx, dy;
    Dir(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }
    public int moveX(int x, int times) {
      return x + times * dx;
    }
    public int moveY(int y, int times) {
      return y + times * dy;
    }
  }
  
}
////// way2 not using enum

class Pair{
  int x;
  int y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Solution {
  public int[][] maze(int n) {
    // Write your solution here.
    int[][] maze = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                maze[i][j] = 0;
            } else {
                maze[i][j] = 1;
            }
        }
    }
    generateMz(maze, 0, 0);
    return maze;
  }
  private void generateMz(int[][] maze, int x, int y) {
    int[] Dir = generateDir();
    for (int dir : Dir) {
      int nx = getCoord(x, y, dir, 2).x;
      int ny = getCoord(x, y, dir, 2).y;
      if (checkValid(nx, ny, maze)) {
        int sx = getCoord(x, y, dir, 1).x;
        int sy = getCoord(x, y, dir, 1).y;
        maze[nx][ny] = 0;
        maze[sx][sy] = 0;
        generateMz(maze, nx, ny);
      }
    }
  }
  
  private Pair getCoord(int x, int y, int dir, int i) {
    int nx, ny;
    if (dir == 0) {
      nx = x - i;
      ny = y;
    } else if (dir == 1) {
      nx = x;
      ny = y + i;
    } else if (dir == 2) {
      nx = x + i;
      ny = y;
    } else {
      nx = x;
      ny = y - i;
    }
    return new Pair(nx, ny);
  }
  
  private boolean checkValid(int x, int y, int[][] maze) {
    int m = maze.length, n = maze[0].length;
    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 1) {
      return true;
    }
    return false;
  }
  
  private int[] generateDir() {
    int[] out = {0,1,2,3};
    for (int i = 0; i < 4; i++) {
      int offset = (int) (Math.random() * (4 - i));
      int temp = out[i];
      out[i] = out[i + offset];
      out[i + offset] = temp;
    }
    return out;
  }
}
