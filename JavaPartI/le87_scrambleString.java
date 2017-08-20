/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] hset = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hset[s1.charAt(i) - 'a']++;
            hset[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hset[i] != 0) {
                return false;
            }
        }
        int n = s1.length();
        for (int j = 1; j < n; j++) {
            if (isScramble(s1.substring(0, j), s2.substring(0, j)) 
              &&isScramble(s1.substring(j), s2.substring(j))) {
                return true;
            }
            if (isScramble(s1.substring(0, j), s2.substring(n - j))
              &&isScramble(s1.substring(j), s2.substring(0, n - j))) {
                return true;
            }
        }
        return false;
    }
}
