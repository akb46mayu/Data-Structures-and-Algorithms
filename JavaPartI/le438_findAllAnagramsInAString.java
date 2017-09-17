class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] dict = new int[26];
        int numele = 0;
        int n = s.length();
        for (char ch : p.toCharArray()) {
            dict[ch - 'a']++;
            if (dict[ch - 'a'] == 1) {
                numele++;
            }
        }
        int k = p.length(); // window size
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            dict[ch - 'a']--;
            if (i < k) {
                if ( dict[ch - 'a'] == 0) {
                    numele--;
                }
            } else {  
                if ( dict[ch - 'a'] == 0) {
                    numele--;
                } 
                char prev = s.charAt(i - k);
                dict[prev - 'a']++;
                if ( dict[prev - 'a'] == 1) {
                    numele++;
                }
            }
            if (numele == 0) {
                res.add(i - k + 1);
            }
        }
        return res;
    }
}

/// way II 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] dict = new int[256];
        int numele = 0;
        int n = s.length();
        for (char ch : p.toCharArray()) {
            dict[ch]++;
            if (dict[ch] == 1) {
                numele++;
            }
        }
        int k = p.length(); // window size
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            dict[ch]--;
            if ( dict[ch] == 0) {
                numele--;
            }
            if (i >= k) {
                char prev = s.charAt(i - k);
                dict[prev]++;
                if ( dict[prev] == 1) {
                    numele++;
                } 
            }            
            if (numele == 0) {
                res.add(i - k + 1);
            }
        }
        return res;
    }
}
