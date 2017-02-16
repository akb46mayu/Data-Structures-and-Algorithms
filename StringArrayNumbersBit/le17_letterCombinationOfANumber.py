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


class Solution2(object): #dfs
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        dict = {'2':['a','b','c'],
                '3':['d','e','f'],
                '4':['g','h','i'],
                '5':['j','k','l'],
                '6':['m','n','o'],
                '7':['p','q','r','s'],
                '8':['t','u','v'],
                '9':['w','x','y','z']
                }
        if len(digits) == 0:
            return []
        out = []
        self.dfs(0, '', out, digits, dict)
        return out
        
    def dfs(self, layernum, tempstr, out, digits, dict):
        digitslen = len(digits)
        if layernum == digitslen:
            out.append(tempstr)
            return 
        for ch in dict[digits[layernum]]:
            self.dfs( layernum+1, tempstr+ch, out, digits, dict)
