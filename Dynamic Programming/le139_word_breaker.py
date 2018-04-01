"""
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
"""

class Solution(object):  # dp solution left big seg, right small seg
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        hset = collections.Counter(wordDict)
        n = len(s)
        dp = [False] * n
        if n == 1:
            return s in hset
        dp[0] = True if s[0] in hset else False
        for j in range(1, n):
            for i in range(0, j + 1):
                if i == 0:
                    if s[:j+1] in hset:
                        dp[j] = True
                        break
                else:
                    if dp[i - 1] and (s[i:j+1] in hset):
                        dp[j] = True
                        break
        return dp[n - 1]
    ####################################

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
