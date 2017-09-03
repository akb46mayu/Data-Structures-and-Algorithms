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
//// way 2 use 0 index.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hset = getSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n]; // whether is it spearable 
        for (int k = 0; k < n; k++) {
            for (int j = k; j >= 0; j--) {
                String str = s.substring(j, k + 1);
                if (hset.contains(str)) {
                    if (j == 0) {
                        dp[k] = true;
                        break;
                    } else {
                        if (dp[j - 1] == true) {
                            dp[k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[n - 1];
    }
    private Set<String> getSet(List<String> wordDict) {
        Set<String> hset = new HashSet<>();
        for (String str : wordDict) {
            if (!hset.contains(str)) {
                hset.add(str);
            }
        }
        return hset;
    }
}
