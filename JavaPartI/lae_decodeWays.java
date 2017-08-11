public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        // base case
        for (int j = 2; j <= n; j++) {
            int one = s.charAt(j - 1) -'0';
            int two = one + 10 * (s.charAt(j - 2) -'0');
            if (one >= 1 && one <= 9) {
             dp[j] += dp[j - 1];
            }
            if (two >= 10 && two <= 26) {
             dp[j] += dp[j - 2];
            }
        }
        return dp[n];
    }
}
