/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] hmap = new int[n];
        int m = edges.length;
        for (int i = 0; i < n; i++) {
            hmap[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = find(edges[i][0], hmap);
            int y = find(edges[i][1], hmap);
            if (x == y) {
                return false;
            }
            hmap[x] = y;
        }
        return n - 1 == m;
    }
    
    private int find(int x, int[] hmap) {
        if (x == hmap[x]) {
            return x;
        }
        return find(hmap[x], hmap);
    }
}
