class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or len(s) <= 1:
            return s
        a = list(s)
        i, j = 0, len(a) - 1
        while i < j:
            a[i], a[j] = a[j], a[i]
            i += 1
            j -= 1
        return ''.join(a)

    
## use a stack
class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or len(s) <= 1:
            return s
        a = list(s)
        stack = []
        res = []
        for ele in a:
            stack.append(ele)
        while stack:
            res.append(stack.pop())
        return ''.join(res)
