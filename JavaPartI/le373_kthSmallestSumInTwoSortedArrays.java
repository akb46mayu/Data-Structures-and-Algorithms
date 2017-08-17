
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

class MyComparator implements Comparator<Cell> {
    public int compare(Cell o1, Cell o2) {
        if (o1.val == o2.val) {
          return 0;
        }
        return o1.val < o2.val ? -1 : 1;
    }
}

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if (m == 0 || n == 0 || k == 0) {
            return res;
        }
        if (k > m * n) {
            k = m * n;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(1, new MyComparator());
        boolean[][] visit = new boolean[m][n];
        pq.offer(new Cell(0, 0, nums1[0] + nums2[0]));
        visit[0][0] = true;
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        while (k >= 1) {
            Cell temp = pq.poll();
            int x = temp.x, y = temp.y, val = temp.val;
            int[] subres = new int[2];
            subres[0] = nums1[x];
            subres[1] = nums2[y];
            res.add(subres);
            for (int j = 0; j < 2; j++) {
                int newx = x + dx[j], newy = y + dy[j];
                if (newx < m && newy < n && visit[newx][newy] == false) {
                  pq.offer(new Cell(newx, newy, nums1[newx] + nums2[newy]));
                  visit[newx][newy] = true;
                }
            }
            k--;
        }
        return res;
    }
}
