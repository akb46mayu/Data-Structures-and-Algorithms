class LFUCache {
    Map<Integer, Integer> lval; 
    Map<Integer, Integer> lcount;
    Map<Integer, LinkedHashSet<Integer>> lset;  // coun(freq) : linkedhashset
    int cap;
    int mincount = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        lval = new HashMap<>();
        lcount = new HashMap<>();
        lset = new HashMap<>();
        lset.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!lval.containsKey(key)) {
            return -1;
        }
        int count = lcount.get(key);
        lcount.put(key, count + 1);
        lset.get(count).remove(key); //
        if (count == mincount && lset.get(mincount).size() == 0) { // update mincount
            mincount++;
        }
        if (!lset.containsKey(count + 1)) {
            lset.put(count + 1, new LinkedHashSet<Integer>());
        }
        lset.get(count + 1).add(key);
        return lval.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (lval.containsKey(key)) {
            lval.put(key, value);
            get(key);
            return;
        }
        if (lval.size() >= cap) {
            int evict = lset.get(mincount).iterator().next();
            lset.get(mincount).remove(evict);  // remove the min freq and old added element.
            lval.remove(evict);
        }
        lval.put(key, value);
        lcount.put(key, 1);
        mincount = 1;
        lset.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
