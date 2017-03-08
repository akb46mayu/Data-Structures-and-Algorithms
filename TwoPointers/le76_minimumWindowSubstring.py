"""
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

"""

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not s or not t:
            return ''
        dict_src = dict.fromkeys(t, 0)
        dict_target = {} # unchaged
        for c in t:
            dict_target[c] = dict_target.get(c,0) + 1
        print dict_src, dict_target
        count = 0 # sum of all the values in the hash from dicttarget
        i = 0
        ans = ''
        n = len(s)
        j = 0
        while j<= n-1: 
            if s[j] in dict_target: # prepare the hash for the current src window
                if dict_src[s[j]] < dict_target[s[j]]:
                    count += 1
                dict_src[s[j]] += 1
            if count == len(t): # when count comes to this value, the answer has been prepared
                while i < j:  # i <= j also works
                    if s[i] in dict_target:
                        if dict_target[s[i]] == dict_src[s[i]]:
                           break
                        dict_src[s[i]] -= 1
                    i += 1
                if ans == '' or j - i + 1 < len(ans):
                    ans = s[i:j+1]
                
                dict_src[s[i]] -= 1 
                i += 1
                count -= 1
            j += 1
        return ans 
