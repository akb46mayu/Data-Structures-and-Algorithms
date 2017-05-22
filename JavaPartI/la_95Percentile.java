public class Solution {
  public int percentile95(List<Integer> lengths) {
    // Write your solution here.
    int[] hist = new int[4097];
    int n = lengths.size();
    for (int len : lengths) {
      hist[len]++; 
    }
    int sum = 0;
    int idx = 4097;
    while(sum <= lengths.size() * 0.05) {
      sum += hist[--idx];
    }
    return idx;
  }
}
