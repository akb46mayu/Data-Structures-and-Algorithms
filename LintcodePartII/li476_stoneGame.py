"""
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43


"""

class Solution:
    # @param {int[]} A an integer array
    # @return {int} an integer
    def stoneGame(self, A):
        # Write your code here
        if not A:
            return 0
        m = len(A)
        if m == 1:
            return 0
        dp = [[0]*m for i in range(m)]
        sumv = [0]*m
        sumbase = 0
        for i in range(m):
            sumv[i] = sumbase + A[i]
            #dp[i][i] = 0 # diagonal elemens should be zeros
            if i <= m-2:
               dp[i][i+1] = A[i] + A[i+1]
            sumbase += A[i]
        
        for lenx in range(2, m):
            for i in range(m-lenx):
                j = i + lenx
                s = sumv[j] - sumv[i-1] if i >= 1 else sumv[j]
                dp[i][j] = 0xffffffff
                for k in range(i, j):
                    temp = dp[i][k] + dp[k+1][j] + s
                    dp[i][j] = min(temp, dp[i][j])
        return dp[0][m-1]
