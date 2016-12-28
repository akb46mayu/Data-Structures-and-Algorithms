"""
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
"""
# hard question, using set, list, dict, dfs and bfs

class Solution(object):
    def findLadders(self, beginWord, endWord, wordlist):
        """
        :type beginWord: str
        :type endWord: str
        :type wordlist: Set[str]
        :rtype: List[List[int]]
        """
        visited = set([])
        visited.add(beginWord)
        wordlist.add(endWord)
        
        trace = {w:[] for w in wordlist}
        cur = [beginWord]
        found = False
        results = []
        while cur and not found:  # can not direcly used the template from I
            next = set()
            for word in cur:
                visited.add(word)
            for word in cur:
                for i in range(len(word)):
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        candidate = word[:i]+j+word[i+1:]
                        if candidate not in visited and candidate in wordlist:
                            if candidate == endWord:
                                  found = True
                            next.add(candidate)
                            trace[candidate].append(word)
            cur = next
        
        if found:
            self.backTrack(trace, endWord,  [], results)
        return results
         
    def backTrack(self, trace, word, path, results):
        if not trace[word]:
            results.append([word] + path)
            
        for prev in trace[word]:
            self.backTrack(trace, prev,  [word] + path, results)
