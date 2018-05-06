"""
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.



"""

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        out = []
        dict = {}
        for word in strs:
            sortedword = ''.join(sorted(word))
            dict[sortedword] = [word] if sortedword not in dict else dict[sortedword]+ [word]
        for k in dict:
            out.append(dict[k])
        return out

      
####
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = []
        mdict = {}
        for str in strs:
            ele = ''.join(sorted(list(str)))
            if ele not in mdict:
                mdict[ele] = []
                mdict[ele].append(str)
            else:
                mdict[ele].append(str)
        for k in mdict.keys():
            res.append(mdict[k])
        return res
