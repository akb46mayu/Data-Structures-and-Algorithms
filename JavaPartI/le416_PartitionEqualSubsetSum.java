/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.


*/

public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        // compute sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[sum / 2 + 1][n + 1]; // sum and length of the seq
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= sum /2; i++) {
            dp[i][0] = false;
        } 
        for (int i = 1; i <= sum /2 ; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[sum / 2][n];
    }
}
