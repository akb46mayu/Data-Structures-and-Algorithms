"""
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

"""

class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """

        if k == 0:
            return 0
        ans = 0
        left, right = 0, 0
        dict = {}
        n = len(s)
        while right <= n-1:
            # update the hash, until k is satisfied
            while right <= n - 1 and (s[right] in dict or len(dict) < k):
                dict.setdefault(s[right], 0)
                dict[s[right]] += 1
                right += 1
            # update the output
            ans = max(ans, right - left)
            # update the left pointer positon
            while left < right and len(dict) == k: # each time only remove one element 
                dict[s[left]] -= 1
                if dict[s[left]] == 0:
                    print s[left]
                    del dict[s[left]]
                left += 1
        return ans
