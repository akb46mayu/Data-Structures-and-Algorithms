
public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here.
    if (combo.length == 0) {
	      return combo;
	    }
	    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, new
	    Comparator<Map.Entry<String, Integer>>() {
	    	public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
	            return e1.getValue().compareTo(e2.getValue());
	        }
	    });
	    
	    Map<String, Integer> freqMap = countWord(combo);
	    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
	      if (minHeap.size() < k) {
	        minHeap.offer(entry);
	      } else {
	        if (entry.getValue() > minHeap.peek().getValue()) {
	          minHeap.poll();
	          minHeap.offer(entry);
	        }
	      }
	    }
	    /// print 
	    String[] result = new String[minHeap.size()];
	    for (int i = minHeap.size() - 1; i >= 0; i --) {
	      result[i] = minHeap.poll().getKey();
	    }
	    return result;
	  }
	  
	  private Map<String, Integer> countWord(String[] combo) {
	    Map<String, Integer> hash = new HashMap<String, Integer>();
	    for (String s : combo) {
	        if (hash.containsKey(s)) {
	          Integer temp = hash.get(s);
	          hash.put(s, temp + 1);
	        } else { 
	          hash.put(s, 1);
	        }
	      }
	    return hash;
	  }
}
////////////////// the other way of defining the comparator
class PairComparator implements Comparator<Map.Entry<String, Integer>> { 
    	public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            return e1.getValue().compareTo(e2.getValue());
        }
}
PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, new PairComparator());
