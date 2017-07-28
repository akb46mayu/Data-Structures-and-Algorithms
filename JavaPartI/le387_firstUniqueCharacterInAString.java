/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

class Point {
    int idx;
    int count;
    Point(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }
}

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Point> hmap = new HashMap<>();
        int n = s.length();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Point temp = hmap.get(ch);
            if (temp != null) {
                temp.count += 1;
            } else {
                hmap.put(ch, new Point(i, 1));
            }
        }
        int tag = 0;
        for (Point pt : hmap.values()) {
            if (pt.count == 1 && pt.idx < res) {
                res = pt.idx;
                tag = 1;
            }
        }
        return tag == 1 ? res : -1;
    }
}
