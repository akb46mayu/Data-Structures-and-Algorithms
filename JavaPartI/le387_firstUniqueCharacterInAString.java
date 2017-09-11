/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/
// my initial solution, can deal with any chars not only 256 cases.
class Solution {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            if (count != null) {
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}


////////////////////////////// (not using hash, use an int array)
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] dict = new int[26];
        for (char ch : s.toCharArray()) {
            dict[ch - 'a']++;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (dict[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
