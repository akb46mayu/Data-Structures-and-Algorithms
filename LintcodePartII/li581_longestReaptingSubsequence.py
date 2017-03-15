"""
Given a string, 
find length of the longest repeating subsequence such that the two subsequence don’t 
have same string character at same position, i.e., any ith character 
in the two subsequences shouldn’t have the same index in the original string.

Have you met this question in a real interview? Yes
Example
str = abc, return 0, There is no repeating subsequence

str = aab, return 1, The two subsequence are a(first) and a(second). 
Note that b cannot be considered as part of subsequence as it would be at same index in both.

str = aabb, return 2

"""

class Solution: # SLE problem for current code, TLE for array %2
    # @param {string} str a string
    # @return {int} the length of the longest repeating subsequence
    def longestRepeatingSubsequence(self, str):
        # Write your code here
        if not str:
            return 0
        n = len(str)
        dp = [[0]*(n+1) for _ in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, n+1):
                if i!=j and str[i-1] == str[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return  dp[n][n]


# java solution:   
public class Solution {
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0;i <= n; i++){
            for (int j = 0; j <= n; j++){
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i != j && str.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            
        }
        return dp[n][n];
    }
}
