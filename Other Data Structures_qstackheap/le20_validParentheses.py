"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Show Company Tags
Show Tags
Show Similar Problems

"""
# two invalid cases: odd even number of brackets, and matching of the brackets.
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack, hashmp = [], {'(':')', '[':']', '{':'}'}
        for ch in s:
            if ch in hashmp:
                stack.append(ch)
            elif len(stack)==0 or hashmp[stack.pop()]!= ch:
                return False
        return len(stack) == 0
