public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here.
    
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> tempresult = new ArrayList<Integer>();
	    helper(target, coins, result, 0, tempresult);
	    return result;
	  }
	  
	  public void helper(int target, int[] coins, List<List<Integer>> result, int level, List<Integer> tempresult) {
	    if (level == coins.length - 1) {
	      if (target % coins[level] == 0) {
	        tempresult.add(target/coins[level]);
	        result.add(new ArrayList<Integer>(tempresult));
	        tempresult.remove(tempresult.size() - 1);
	      }
	      return;
	    }
	    for (int k = 0; k <= target/coins[level] ; k++) {
	      tempresult.add(k);
	      helper(target - k*coins[level], coins, result, level + 1, tempresult);
	      tempresult.remove(tempresult.size() - 1);
	    }  
	  }
}
