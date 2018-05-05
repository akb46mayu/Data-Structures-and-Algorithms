class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s is None:
            return False
        if len(s) == 0:
            return True
        i, j = 0, len(s) - 1
        while i < j:
            if not s[i].isalnum():
                i += 1
            elif not s[j].isalnum():
                j -= 1    
            else:
                if s[i].lower() == s[j].lower():
                    i += 1
                    j -= 1
                else:
                    return False
        return True
