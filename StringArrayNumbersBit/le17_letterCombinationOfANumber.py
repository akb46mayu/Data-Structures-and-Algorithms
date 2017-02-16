"""
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


"""

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        chrlist = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        out = []
        for i in digits:
            mystring = chrlist[int(i)]
            tmp = []
            for ch in mystring:
                if len(out):
                   for k in range(len(out)):
                       tmp.append(out[k] + ch)
                else:
                       tmp.append(ch)
            out = tmp  # or use  out =copy.copy(tmp)
        return out
