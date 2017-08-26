class Solution0 {
  public int reverseBits(int x) {
    int left = 31, right = 0;
    while (left >= right) {
    	if ((x >> left & 1) != (x >> right & 1) ) {
    		x ^= (1 << left) | (1 << right);
    	}
    	left--;
    	right++;
    }
    return x;
  }
}
