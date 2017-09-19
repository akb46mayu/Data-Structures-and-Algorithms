class Solution {
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] i : buildings) {
            height.add(new int[]{i[0], -i[2]});
            height.add(new int[]{i[1], i[2]});
        }
        Collections.sort(height, (a,b)-> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a,b)->(b - a)); // maxheap
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                res.add(new int[]{h[0], cur});
            }
            prev = cur;
        }
        return res;
    }
}
