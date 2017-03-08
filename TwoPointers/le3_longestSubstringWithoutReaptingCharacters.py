"""
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

"""

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        n = len(s)
        left = 0
        dict = {}
        k = 0
        for right in range(n):
            if s[right] in dict and dict[s[right]] >= left:
                left = dict[s[right]] + 1
            dict[s[right]] = right
            k = max(k, right - left + 1)
        return k        
