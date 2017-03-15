"""

Given n balloons, indexed from 0 to n-1. 
Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. 
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. 
After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

"""

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)  
        coins = [1] + nums + [1]
        
        n2 = len(coins)
        dp = [[0] * n2 for _ in range(n2)]
        for lenx in range(n):
            for i in range(1, n2-1-lenx):
                j = i + lenx
                dp[i][j] = 0
                for k in range(i, j+1):
                    midval = coins[i-1]*coins[k]*coins[j+1] # previously made a mistake here(I use sum)
                    dp[i][j] = max(dp[i][j], dp[i][k-1] +  midval + dp[k+1][j])
        return dp[1][n]
