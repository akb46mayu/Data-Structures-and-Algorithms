/*
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/


//// use java iterator
public class ZigzagIterator {
    Iterator<Integer> a1, a2, tmp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        a1 = v1.iterator();
        a2 = v2.iterator();
    }

    public int next() {
        if (a1.hasNext()) {
            tmp = a1;
            a1 = a2;
            a2 = tmp;
        }
        return a2.next();
    }

    public boolean hasNext() {
        return a1.hasNext() || a2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

///// do not use java iterator use arraylist instead

public class ZigzagIterator {
    List<Integer> v1, v2;
    int p1, p2;
    boolean first; // 0 : v1, 1 : v2
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        p1 = 0;
        p2 = 0;
        first = v1.size() > 0;
    }

    public int next() {
        int out = first == true ? v1.get(p1++) : v2.get(p2++);
        if (first == true && p2 < v2.size()) {
            first = false;
        } else if (first == false && p1 < v1.size()) {
            first = true;
        }
        return out;
    }

    public boolean hasNext() {
        return p1 < v1.size() || p2 < v2.size();
    }
}
