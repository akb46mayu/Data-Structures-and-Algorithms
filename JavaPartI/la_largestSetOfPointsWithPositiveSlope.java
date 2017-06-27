/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  static class MyComparator implements Comparator<Point>{
    public int compare(Point p1, Point p2) {
      if (p1.x < p2.x) {
        return -1;
      } else if (p1.x > p2.x) {
        return 1;
      } else if (p1.y < p2.y) {
        return -1;
      } else if (p1.y > p2.y) {
        return -1;
      }
      return 0;
    }
  }
  
  public int largest(Point[] points) {
    // Write your solution here.
    int n = points.length;
    int[] dp = new int[n];
    Arrays.sort(points, new MyComparator());
    int glbval = 0;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (points[j].y < points[i].y) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      glbval = Math.max(glbval, dp[i]);
    }
    return glbval == 1 ? 0 : glbval;
  }
}
