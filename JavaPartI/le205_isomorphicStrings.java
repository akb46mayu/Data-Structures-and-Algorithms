class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> hmap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (!hmap.containsKey(ch1)) {
                if (hmap.containsValue(ch2)) {
                    return false;
                }
                hmap.put(ch1,ch2);
            } else if (hmap.get(ch1) != ch2) {
                return false;
            }
        }
        return true;
    }
}
