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
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        if (n - 1 != edges.length) {
            return false;
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            x = findParent(map, x);
            y = findParent(map, y);
            if (x == y) {
                return false;
            }
            map[x] = y;
        }
        return true;
        
    }
    
    private int findParent(int[] map, int x) {
        if (map[x] == x) {
            return x;
        }
        return findParent(map, map[x]);
    }
}
