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
