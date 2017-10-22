class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < 2001; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {
            int c = edge[0], f = edge[1];
            if (find(parent, f) == find(parent, c)) {
                return edge;
            } else {
                parent[find(parent, c)] = find(parent, f);
            }
        }
        return res;
        
    }
    
    private int find(int[] parent, int c) {
        if (c != parent[c]) {
            parent[c] = find(parent, parent[c]);
        }
        return parent[c];
    }
}
