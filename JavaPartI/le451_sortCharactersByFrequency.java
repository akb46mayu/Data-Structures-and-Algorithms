class MyComparator implements Comparator<Map.Entry<Character, Integer>>{
    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
public class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        char[] res = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(1, new MyComparator());
        for (char ch : res) {
            Integer count = map.get(ch);
            if (count != null) {
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     pq.offer(entry);
        // }
        pq.addAll(map.entrySet());
        int i = 0;
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int count = entry.getValue();
            char ch = entry.getKey();
            for (int j = 0; j < count; j++) {
                res[i] = ch;
                i++;
            }
        }
        return new String(res);
    }
}
