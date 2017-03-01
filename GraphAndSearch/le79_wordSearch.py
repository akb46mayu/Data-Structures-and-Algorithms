"""

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.


"""

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not word:
            return True
        m = len(board)
        n = len(board[0])
        if m == 0 or n == 0:
            return False
        visited = [[False for j in range(n)] for i in range(m)]
        for i in range(m):
            for j in range(n):
                if self.dfs(board, word, visited, i, j):
                    return True
        return False
        
    def dfs(self, board,  word, visited, row, col):
        m, n = len(board), len(board[0])
        if word == '':
            return True
        if row < 0 or row >= m or col < 0 or col >= n:
            return False

        if word[0] == board[row][col] and not visited[row][col]:
            visited[row][col] = True
            bexp = self.dfs(board, word[1:], visited, row+1, col) or\
                   self.dfs(board, word[1:], visited, row-1, col) or\
                   self.dfs(board, word[1:], visited, row, col+1) or\
                   self.dfs(board, word[1:], visited, row, col-1)
            if bexp:
                return True
            else:
                visited[row][col] = False
        return False
