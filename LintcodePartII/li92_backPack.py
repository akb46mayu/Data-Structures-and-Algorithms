"""
Given n items with size Ai, an integer m denotes the size of a backpack.
How full you can fill this backpack?

 Notice

You can not divide any item into small pieces.

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, 
we can select [2, 3, 5], so that the max size we can fill this backpack is 10. 
If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.


"""
class Solution: # dp[i]=1: means size i can be achieved. dp[s-item] = 1 and use current item, we know dp[s] = 1
    # @param m: An integer m denotes the size of a backpack
    # @param A: Given n items with size A[i]
    # @return: The maximum size
    def backPack(self, m, A):
        # write your code here
            if not A:
               return 0
            n = len(A)
            dp = [0] * (m+1)
            dp[0] = 1
            size = 0
            for item in A:
                for s in range(m,-1,-1):
                    if s - item >= 0 and dp[s-item] == 1:
                        dp[s] = 1
                        size = max(size, s)
            return size

class Solution: # TLE problem
    # @param m: An integer m denotes the size of a backpack
    # @param A: Given n items with size A[i]
    # @return: The maximum size
    def backPack(self, m, A):
        # write your code here
            if not A:
               return 0
            n = len(A)
            dp = [[0]*(m+1) for i in range(2)]
            dp[0][0] = 1
            size = 0
            for i in range(1,n+1):
                for s in range(m+1):
                    if s - A[i-1] >= 0:
                        dp[i%2][s] = dp[(i-1)%2][s-A[i-1]] or dp[(i-1)%2][s]
                    else:
                        dp[i%2][s] = dp[(i-1)%2][s]
                    if dp[i%2][s] == 1 and s > size:
                         size = s    
            return size
