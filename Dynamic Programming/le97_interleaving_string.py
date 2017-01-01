"""
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

"""


class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        n1, n2, n3 = len(s1), len(s2), len(s3)
        if n1 + n2 != n3:
            return False
        f = [[False]*(n2+1) for i in range(n1+1)]
        for j in range(n2+1):
            f[0][j] = s2[:j]==s3[:j]
        for i in range(n1+1):
            f[i][0] = s1[:i] == s3[:i]
        for i in range(1, n1+1):
            for j in range(1, n2+1):
                f[i][j] = (f[i-1][j] and s1[i-1] == s3[i+j-1]) or (f[i][j-1] and s2[j-1]==s3[i+j-1] )
        return f[n1][n2]
