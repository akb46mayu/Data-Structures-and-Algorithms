class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
    }                                                                              
}
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = getMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, new MyComparator());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
            
        }             
        for (int i = pq.size() - 1; i >= 0; i--) {
          res.add(0, pq.poll().getKey());
        }
        return res;
    }
    
    private Map<Integer, Integer> getMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.get(i);
            if (count != null) {
                map.put(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }    
}
