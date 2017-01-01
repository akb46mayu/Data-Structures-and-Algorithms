"""
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

"""

class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        n1, n2 = len(word1), len(word2)
        f = [[0]*(n2+1) for i in range(n1+1)]
        for i in range(n1+1):
            f[i][0] = i  
        for j in range(n2+1):
            f[0][j] = j
   
        for i in range(1,n1+1):
            for j in range(1,n2+1):
                if word1[i-1] == word2[j-1]:
                    f[i][j] = f[i-1][j-1]
                else:
                    f[i][j] = min(f[i-1][j], f[i][j-1], f[i-1][j-1])+1
        return f[n1][n2]
