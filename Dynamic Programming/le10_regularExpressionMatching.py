"""
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Show Company Tags
Show Tags
Show Similar Problems


"""


class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        
        out = [[False for i in range(len(p)+1)] for j in range(len(s)+1)]
        out[0][0] = True
        for j in range(2, len(p)+1):
            if p[j-1] == '*':
               out[0][j] = out[0][j-2]
        for j in range(1,len(p) + 1):
            for i in range(1,len(s) + 1):
                if p[j-1] == '*':
                    out[i][j] = out[i][j-2]
                    if p[j-2]== s[i-1] or p[j-2]== '.':
                        out[i][j] |= out[i-1][j]
                else:
                    if p[j-1]==s[i-1] or p[j-1]=='.':
                        out[i][j] = out[i-1][j-1]

        return out[len(s)][len(p)]
