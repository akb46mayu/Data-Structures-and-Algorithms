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
    int res = 0;
    
    for (int i = 0; i < n - 1; i++) {
      int same = 0;
      int samex = 0;
      Point base = points[i];
      int slopesum = 0;
      Map<Double, Integer> hmap = new HashMap<>();
      for (int j = i + 1; j < n; j++) {
        Point temp = points[j];
        if (base.x == temp.x && base.y == temp.y) { // dup
          same = (same == 0 ? 2 : same + 1);
        } else if (base.x == temp.x) {
          samex = (samex == 0 ? 2 : samex + 1);
        } else {
          double slope = (temp.y - base.y - 0.0) / (temp.x - base.x);
          if (!hmap.containsKey(slope)) {
            hmap.put(slope, 2);
          } else {
            hmap.put(slope, hmap.get(slope) + 1);
          }
          slopesum = Math.max(slopesum, hmap.get(slope));
        }
      }
      res = Math.max(res, Math.max(subSum(slopesum, same), subSum(samex, same)));
    }
    return res;
  }
  private int subSum(int a, int b) {
    if (a >= 1 && b >= 1) {
      return a + b - 1;
    } 
    return a + b;
  }
}
