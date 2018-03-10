class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        s = str
        if len(s) == 0: return 0
        ls = list(s.strip())
        sign = -1 if ls[0] == '-' else 1
        if ls[0] in ['+', '-']: del(ls[0])
        res, i = 0, 0
        maxval = 2**31 - 1
        minval = -2**31
        n = len(ls)
        while i < n and ls[i].isdigit():
            res = res * 10 + ord(ls[i]) - ord('0')
            i += 1
        return max(minval, min(sign * res, maxval))
