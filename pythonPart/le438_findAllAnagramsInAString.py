class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        dictp = {}
        for ch in p:
            if ch in dictp:
                dictp[ch] += 1
            else:
                dictp[ch] = 1
        
        #dictp = Counter(s)]
        n = len(s)
        numele = len(dictp)
        k = len(p)
        res = []
        for i in range(n):
            ch = s[i]
            if ch in dictp:
                dictp[ch] -= 1
                if dictp[ch] == 0:
                    numele -= 1
            if i >= k:
                prev = s[i - k]
                if prev in dictp:
                    dictp[prev] += 1
                    if dictp[prev] == 1:
                        numele += 1
            if numele == 0:
                res.append(i - k + 1)
        return res
