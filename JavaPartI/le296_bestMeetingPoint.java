/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
*/

public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        } 
        int n = grid[0].length;
        List<Integer> xdirec = new ArrayList<>();
        List<Integer> ydirec = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xdirec.add(i);
                    ydirec.add(j);
                }
            }
        }
        //
        return getDist(xdirec, 0) + getDist(ydirec, 1);
    }
    private int getDist(List<Integer> dlist, int direc) {
        // direc 0 : x direc
        if (direc == 1) {
            Collections.sort(dlist);
        }
        int n = dlist.size();
        int mid = n / 2;
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            res += Math.abs(dlist.get(mid) - dlist.get(i)) + Math.abs(dlist.get(mid) - dlist.get(j));
            i++;
            j--;
        }
        return res;
    } 
    
}
