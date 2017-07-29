/* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

*/

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return s;
        }
        String res = "";
        int lens = s.length();
        int lent = t.length();
        Map<Character, Integer> hmap= new HashMap<>();
        // hash
        for (char ch : t.toCharArray()) {
            Integer temp = hmap.get(ch);
            if (temp != null) {
                hmap.put(ch, temp + 1);
            } else {
                hmap.put(ch, 1);
            }
        }
        int count = t.length();
        int minlen = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < lens; j++) {
            char ch = s.charAt(j);
            if (hmap.containsKey(ch)) {  // put element into the window
                hmap.put(ch, hmap.get(ch) - 1);
                if (hmap.get(ch) >= 0) {
                    count--;
                }
            }
            char lastch = ' ';
            while (count == 0) {
                Integer num2 = hmap.get(lastch);
                if (num2 != null && num2 >= 1) {
                        count++;
                        break;
                }
                lastch = s.charAt(i);
                if (hmap.containsKey(lastch)) {
                    hmap.put(lastch, hmap.get(lastch) + 1);
                }
               
                if (j - i + 1 < minlen) {
                    res = s.substring(i, j + 1);
                    minlen = j - i + 1;
                }
                i++;
            }
        }
        return res;
    }
}
