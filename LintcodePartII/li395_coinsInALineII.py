"""
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.

"""

class Solution: # TLE problem
    # @param values: a list of integers
    # @return: a boolean which equals to True if the first player will win
    def firstWillWin(self, values):
        # write your code here
        if not values:
            return True
        n = len(values)
        dp = [0] * (n + 1)
        flag =  [0] * (n + 1)
        sumval = 0
        for i in range(0, n+1):
            if i < n:
               sumval += values[i]
            self.search(values, dp, flag, i)
        return dp[n] > sumval/2
        
    def search(self, values, dp, flag, i):
        if flag[i] == 1:
            return dp[i]
        n = len(values)
        flag[i] == 1
        if i == 0:
            dp[i] = 0
        elif i == 1:
            dp[i] = values[n-1]
        elif i == 2:
            dp[i] = values[n-1] + values[n-2]
        elif i == 3:
            dp[i] = values[n-2] + values[n-3]
        else:
            temp1 = min(self.search(values, dp, flag, i-2), \
                        self.search(values, dp, flag, i-3)) \
                    + values[n-i]
            temp2 = min(self.search(values, dp, flag, i-3), \
                        self.search(values, dp, flag, i-4)) \
                    + values[n-i] + values[n-i+1]
            dp[i] = max(temp1, temp2)
        return dp[i]
