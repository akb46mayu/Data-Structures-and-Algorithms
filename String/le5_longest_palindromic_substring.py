""

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
""

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        ansl, ansr, maxval = 0,0,0
        n = len(s)
        for i in range(1, 2*n):
            if i&1:  # i is odd
                left = i/2
                right = left
            else:
                left = i/2-1
                right = left + 1
            while left>=0 and right <n and s[left] == s[right]:
                left -= 1
                right += 1
            left += 1
            right -= 1
            if right - left > maxval:
                maxval = right - left
                ansl, ansr = left, right
        return s[ansl:ansr+1]
