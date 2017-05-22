public class Solution {
  private int count;
  private Integer sample;
  public Solution() {
    // Write your constructor code here if necessary.
    this.count = 0;
    this.sample = null;
  }
  
  public void read(int value) {
    // Write your implementation here.
    count++;
    int prob = (int) (Math.random() * count);
    if (prob == 0) {
      this.sample = value;
    }
  }
  
  public Integer sample() {
    // Write your implementation here.
    
    return sample;
  }
}
