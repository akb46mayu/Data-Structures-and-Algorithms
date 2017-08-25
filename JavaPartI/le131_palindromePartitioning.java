class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // dp for palindrome.
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                    dp[i][j] = true;
                }
            }
        }
        // back tracking:
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        dfs(dp, s, 0, temp, res);
        return res;
    }
    
    private void dfs(boolean[][] dp, String s, int left, List<String> temp, List<List<String>> res) {
        int n = s.length();
        if (left == n) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int j = 0; left + j < n; j++) {// j is the offset
            if (dp[left][left + j] == true) {
                temp.add(s.substring(left, left + 1 + j));
                dfs(dp, s, left + j + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
