class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
    
        result = []
        self.partitionRecur(result, [], s, 0)
        return result
    def partitionRecur(self, result, cur, s, i):
        
        if i == len(s):
            result.append(list(cur))
        else:
            
            for j in xrange(i,len(s)):
                if self.isPalindrome(s[i:j+1]):
                    cur.append(s[i:j+1])
                    self.partitionRecur(result, cur, s, j+1)
                    cur.pop()
     
    def isPalindrome(self, s):
        for i in xrange(len(s)/2):
            if s[i]!=s[-i-1]:
                return False
                
        return True
