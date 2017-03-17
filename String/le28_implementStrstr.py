"""
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
"""

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        # be careful of the corner case, when src == target == '', answer is 0
        if haystack is None or needle is None:  # i suggest to add this. 
            return -1
        tl = len(needle)
        n = len(haystack)
        for i in range(n-tl+1): # in the program itself it automatically include the case when src = '' and target = ''
            if haystack[i:i+tl] == needle:
                return i
        return -1
