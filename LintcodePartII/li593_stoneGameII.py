"""
There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [1, 4, 4, 1], in the best solution, the total score is 18:

1. Merge second and third piles => [2, 4, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43

"""


class Solution:
    # @param {int[]} A an integer array
    # @return {int} an integer
    def stoneGame2(self, A):
        # Write your code here
        if not A:
            return 0
        m = len(A)
        if m == 1:
            return 0
        n = 2*m
        dp = [[sys.maxint]*n for i in range(n)]
        sumv = [0]
        sumbase = 0
        # sum dp
        for i in range(n):
            sumv.append(sumv[-1] + A[i%m])
            dp[i][i] = 0
        
        for lenx in range(1, n):
            for i in range(n -lenx):
                j = i + lenx
                if j >= n:
                    continue
                for k in range(i, j):
                    dp[i][j] = min(dp[i][j], dp[i][k]+dp[k+1][j]+sumv[j+1]-sumv[i])
    
        out = sys.maxint
        for i in range(m):
            out = min(out, dp[i][i+m-1])
        return out
                
