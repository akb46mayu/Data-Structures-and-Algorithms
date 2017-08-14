
/// my sol without using java's next, hasNext
public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    int[] p;
    int i = 0, k = 0;
    List<ArrayList<Integer>> vecs;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        k = vecs.size();
        p = new int[k];
        this.vecs = vecs;
        int count = 0;
        while (count < k && p[i % k] == vecs.get(i % k).size()) {
            i++;
            count++;
        }
        
    }

    public int next() {
        // Write your code here (assume the next element exist)
        int out = vecs.get(i % k).get(p[i % k]++);
        i++;
        return out;
    }

    public boolean hasNext() {
        // Write your code here   
        int count = 0;
        while (count < k) {
            if (p[i % k] < vecs.get(i % k).size()) {
                return true;
            }
            i++;
            count++;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
 
 
 ///////////////  use java api
 
 public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    List<Iterator<Integer>> vecs;
    int k; // num of lists.
    int i; // current row
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        this.vecs = new ArrayList<Iterator<Integer>>();
        k = vecs.size();
        i = 0;
        for (List<Integer> vec : vecs) {
            this.vecs.add(vec.iterator());
        }
    }

    public int next() {
        // Write your code here
        int res = vecs.get(i % k).next();
        i++;
        return res;
    }

    public boolean hasNext() {
        // Write your code here 
        int count = 0;
        while(count < k) {
            if (vecs.get(i % k).hasNext()) {
                return true;
            }
            i++;
            count++;
        }
        return false;
    }
}
