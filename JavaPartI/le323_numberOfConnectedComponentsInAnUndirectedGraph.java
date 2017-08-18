public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        if (edges.length == 0) {
            return n;
        }
        int m = edges.length;
        Map<Integer, List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hmap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
                hmap.get(edges[i][0]).add(edges[i][1]);
                hmap.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> hset = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!hset.contains(i)) {
                //set.add(i);
                bfs(i, hmap, hset);
                count++;
            }
        }
        return count;
    }
    
    private void bfs(int i, Map<Integer, List<Integer>> hmap, Set<Integer> hset) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()) {
            int qsize = q.size();
            for (int j = 0; j < qsize; j++) {
                int temp = q.poll();
                hset.add(temp);
                for (int nei : hmap.get(temp)) {
                    if (!hset.contains(nei)) {
                        q.offer(nei);
                        hset.add(nei);
                    }
                }
            }
        }
    }
}
///// dfs
