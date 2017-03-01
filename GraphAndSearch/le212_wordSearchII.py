"""
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.


"""









################# it passed through lint compiler but failed the leet because of  time limit exceeding
class TrieNode:
    def __init__(self):
        self.childs = {}
        self.isWord = False
    def insert(self, word):
        node = self
        for letter in word:
            child = node.childs.get(letter)
            if not child:
                child = TrieNode()
                node.childs[letter] = child
            node = child
        child.isWord = True

class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if not words:
            return []
        m, n = len(board), len(board[0])
        if m == 0 or n == 0:
            return []
        trie = TrieNode()
        visited = [[False for j in range(n)] for i in range(m)]
        curword, result = [], {}
        for word in words:
            trie.insert(word)
        for i in range(m):
            for j in range(n):
                self.dfs(board, trie, visited, i , j, curword, result)
        return result.keys()
        
    def dfs(self, board, trie, visited, i, j, curword, result):
        m, n = len(board), len(board[0])
        if not trie or i<0 or i>=m or j<0 or j>=n or visited[i][j]:
            return
        if board[i][j] not in trie.childs:
            return
        curword.append(board[i][j])
        nextnode = trie.childs[board[i][j]]
        if nextnode.isWord:
            result[''.join(curword)] = True
        visited[i][j] = True
        self.dfs( board, nextnode, visited, i+1, j, curword, result)
        self.dfs( board, nextnode, visited, i-1, j, curword, result)
        self.dfs( board, nextnode, visited, i, j+1, curword, result)
        self.dfs( board, nextnode, visited, i, j-1, curword, result)
        visited[i][j] = False
        curword.pop()
        
