class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        stack = []
        temp = []
        self.parentHelper(n, res, temp, stack, 0)
        return res
    
    
    def parentHelper(self, n, res, temp, stack, level):
        if 2 * n == level:
            if len(stack) == 0:
                res.append(''.join(temp))
            return 
        if len(stack) == 0 or stack[-1] == '(':
            stack.append('(')
            temp.append('(')
            self.parentHelper(n, res, temp, stack, level + 1)
            stack.pop()
            temp.pop()
        if len(stack) != 0 and stack[-1] == '(':
            stack.pop()
            temp.append(')')
            self.parentHelper(n, res, temp, stack, level + 1)
            stack.append('(')
            temp.pop()
