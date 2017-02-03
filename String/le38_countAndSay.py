"""

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
"""
class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        seq = '1'
        for i in range(n-1):
            seq = self.getNext(seq)
            
        return seq
    
    
    def getNext(self, seq):
        i = 0
        result = ''
        while i < len(seq):
            count = 1
            while i<len(seq)-1 and seq[i]==seq[i+1]:
                i+=1
                count += 1
            result += str(count) + seq[i]
            i += 1
        return result
