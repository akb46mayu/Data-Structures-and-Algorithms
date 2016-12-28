"""
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Show Company Tags
"""
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        wordList.add(endWord)
        visited = set([beginWord])  # if use list, we will have time exceed error
        cur = [beginWord]
        distance = 0
        while cur:
            next = []
            for word in cur:
                if word == endWord:
                    return distance+1
                for i in range(len(word)):
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        candidate = word[:i] + j + word[i+1:]
                        if candidate not in visited and candidate in wordList:
                            next.append(candidate)
                            visited.add(candidate)
            distance+=1 # if endword not found, distance will increase but will not be the output
            cur = next
        return 0
            
