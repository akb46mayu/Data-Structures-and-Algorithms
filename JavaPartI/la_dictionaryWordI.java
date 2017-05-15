public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here.
    int n = input.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true; // zero element is in the set.
    Set<String> mySet = generateSet(dict);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] == true && mySet.contains(input.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
  
  private Set<String> generateSet(String[] dict) {
    Set<String> mySet = new HashSet<String>();
    for (String str : dict) {
      mySet.add(str);
    }
    return mySet;
  }
}
