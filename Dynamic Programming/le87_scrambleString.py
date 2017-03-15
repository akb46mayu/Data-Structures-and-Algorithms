"""
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


"""
class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if len(s1) != len(s2):
            return False
        s3 = s2[::-1]
        if s1 == s2 or s1 == s3:
            return True
        index = lambda x: ord(x) - 97
        count1, count2, count3 = [0]*26, [0]*26, [0]*26
        n = len(s1)
        for i in range(1, n):
            count1[index(s1[i-1])] += 1
            count2[index(s2[i-1])] += 1
            count3[index(s3[i-1])] += 1
            if count1 == count2 and self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:]):
                return True 
            if count1 == count3 and self.isScramble(s1[:i], s3[:i]) and self.isScramble(s1[i:], s3[i:]):
                return True
        return False
            


