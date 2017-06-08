public class Solution {
  public int minCost(int[] cuts, int length) {
    // Write your solution here.
    int[] cutCost = new int[cuts.length + 2];
    for (int i = 0; i < cuts.length; i++) {
      cutCost[i + 1] = cuts[i];
    }
    int newlen = cutCost.length;
    cutCost[newlen - 1] = length;
    int[][] mc = new int[newlen][newlen];
    for (int i = 1; i < cutCost.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (i - j == 1) {
          mc[j][i] = 0;
        } else {
          mc[j][i] = Integer.MAX_VALUE;
          for (int k = j + 1; k <= i - 1; k++) {
            mc[j][i] = Math.min(mc[j][i], mc[j][k] + mc[k][i]);
          }
          mc[j][i] += cutCost[i] - cutCost[j];
        }
      }
    }
    return mc[0][newlen - 1];
  }
}
