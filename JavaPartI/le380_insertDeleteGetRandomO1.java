class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>(); // check
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int pos = map.get(val);
            if (pos < list.size() - 1) {
                int lastele = list.get(list.size() - 1);
                list.set(pos, lastele);
                map.put(lastele, pos);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int n = list.size();
        int idx = (int) ( Math.random() * n );
        return list.get(idx);
    }   
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
