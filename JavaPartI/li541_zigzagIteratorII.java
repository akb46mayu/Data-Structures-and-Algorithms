
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
 
 
