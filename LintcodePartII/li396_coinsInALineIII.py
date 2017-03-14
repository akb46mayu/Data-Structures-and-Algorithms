"""

There are n coins in a line. Two players take turns to take a coin from one of the ends of the line 
until there are no more coins left. The player with the larger amount of money wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.
"""
class Solution: # better solution
    # @param values: a list of integers
    # @return: a boolean which equals to True if the first player will win
    def firstWillWin(self, values):
        # write your code here
        if not values:
            return True
        m = len(values)
        if m == 1:
            return True
        sum = [0]*m
        dp = [[0]*m for i in range(m)]
        sumbase = 0
        for i in range(m):
            sum[i] = sumbase + values[i]
            dp[i][i] = values[i]
            sumbase += values[i]
        for lenx in range(1,m):   
            for i in range(m-lenx):
                j = i + lenx
                if j >= m:
                    continue
                s = sum[j] - sum[i-1] if i >= 1 else sum[j]
                dp[i][j] = max(s - dp[i+1][j], s - dp[i][j-1])
        return 2*dp[0][m-1] > sum[m-1]

class Solution:  # TLE problem
    # @param values: a list of integers
    # @return: a boolean which equals to True if the first player will win
    def firstWillWin(self, values):
        # write your code here
        if not values:
            return True
        m = len(values)
        #dp = [[0]*m for i in range(m)]
        flag = [[0]*m for i in range(m)]
        sumtotal = 0
        if m == 1:
            return True
        for i in range(m-1):
            #dp[i][i] = values[i]
            #dp[i][i+1] = max(values[i], values[i+1])
            sumtotal += values[i]
        sumtotal += values[m-1]
        return self.dpSearch(flag, values, 0, m-1) > sumtotal/2
        
    def dpSearch(self, flag, values, i, j):
        m = len(values)
        
        if i < 0 or i >= m or j < 0 or j >= m:
            return 
        if flag[i][j] == 1:
            return 
        
        flag[i][j] == 1
        if i == j:
            return values[i]
        elif i + 1 == j:
            return max(values[i], values[i+1])
        else:
            #left = min(dp[i+2][j], dp[i+1][j-1]) + values[i]
            #right = min(dp[i+1][j-1], dp[i][j-2]) + values[j]
            #dp[i][j] = max(let, right)
            
            left = min(self.dpSearch(flag, values, i+2, j), self.dpSearch(flag,  values, i+1, j-1)) + values[i]
            right = min(self.dpSearch(flag,  values, i+1, j-1), self.dpSearch(flag,  values, i, j-2)) + values[j]
            return max(left, right)
