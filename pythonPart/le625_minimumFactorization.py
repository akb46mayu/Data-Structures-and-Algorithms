class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a < 10:
            return a
        res = ''
        for i in range(9, 1, -1):
            while a % i == 0:
                res = str(i) + res
                a /= i
        return int(res) if a == 1 and int(res) < 2 ** 31 else 0
