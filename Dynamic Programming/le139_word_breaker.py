"""
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
"""



class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        n = len(s)
        if n ==0:
            return True
        f = [False]*(n+1)
        f[0] = True
        k = 0 # k is the max length of the word in the dictionary
        for w in wordDict:
            k = max(len(w), k)
        for i in range(n+1):
            for j in range(1, min(i,k)+1):
                if not f[i-j]:
                    continue
                if s[i-j:i] in wordDict:
                    f[i] = True
                    break
        return f[n]
