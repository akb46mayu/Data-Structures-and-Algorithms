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
  public int most(Point[] points) {
    // Write your solution here.
    int n = points.length;
    if (n <= 1) {
      return n;
    }
    int res = 0;
    for (int i = 0; i < n - 1; i++) {
      Map<Double, Integer> hmap = new HashMap<>();
      int samee = 0;
      int samexe = 0;
      int basex = points[i].x, basey = points[i].y;
      int tempmax = 0;
      for (int j = i + 1; j < n; j++) {
        int dx = points[j].x - basex;
        int dy = points[j].y - basey;
        if (dx == 0 && dy == 0) { // dup case
          samee++;
        } else if (dx == 0) { // same x
          samexe++;
        } else {
          double slope = 1.0 * dy / dx;
          if (hmap.containsKey(slope)) {
            hmap.put(slope, hmap.get(slope) + 1);
          } else {
            hmap.put(slope, 1);
          }
          tempmax = Math.max(tempmax, hmap.get(slope));
        }
      }
      res = Math.max(res, Math.max(samexe, tempmax) + samee + 1);
    }
    return res;
  }  
}
