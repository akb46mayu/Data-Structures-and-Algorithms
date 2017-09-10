public class Solution {
  private final int k;
  private int count;
  List<Integer> res = new ArrayList<>();
  public Solution(int k) {
    // Complete the constructor if necessary.
    this.k = k;
    count = 0;
  }
  
  public void read(int value) {
    // Write your implementation here.
    count++;
    if (count <= k) {
      res.add(value);
    } else {
      int idx = (int) (Math.random() * count);
      if (idx < k) {
        res.set(idx, value);
      }
    }
  }
  
  public List<Integer> sample() {
    // Write your implementation here.
    return res;
  }
}
