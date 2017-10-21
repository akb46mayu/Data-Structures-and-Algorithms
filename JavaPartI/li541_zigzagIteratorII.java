
/// my sol without using java's next, hasNext
public class ZigzagIterator2 {
    /*
    * @param vecs: a list of 1d vectors
    */
    int[] p;
    int j, k;
    List<List<Integer>> vecs;
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        k = vecs.size();
        p = new int[k];
        j = 0;
        this.vecs = vecs;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int count = 0;
        while(count < k && p[j % k] >= vecs.get(j % k).size()) {
            j++;
            count++;
        }
        
        int res = vecs.get(j % k).get(p[j % k]);
        p[j % k]++;
        j++;
        return res;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        int count = 0;
        while(count < k && p[j % k] >= vecs.get(j % k).size()) {
            j++;
            count++;
        }
        return p[j % k] < vecs.get(j % k).size();
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
