/* Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if (s == null && t == null) {
            return true;
        }
        int lens = s.length();
        int lent = t.length();
        if (lens != lent) {
            return false;
        }
        Map<Character, Integer> hmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer temp = hmap.get(ch);
            if (temp != null) {
                hmap.put(ch, temp + 1);
            } else {
                hmap.put(ch, 1);
            }
        }
        for (char ch : s.toCharArray()) {
            Integer temp = hmap.get(ch);
            if (temp != null) {
                hmap.put(ch, temp - 1);
            } else {
                return false;
            }
            if (hmap.get(ch) == -1) {
                return false;
            }
        }
        return true;
    }
}
