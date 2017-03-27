


// TLE solution   (recursion)

public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K < 0) {
      return 0;
    }
    if (K == 0){
      return 0;
    }
    if (K == 1){
      return 1;
    }
    return fibonacci(K-1) + fibonacci(K-2);
  }
}

// recursion 
public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 0) {
      return 0;
    }
    
    if (K == 1){
      return 1;
    }
    long[] f = new long[K+1];
    f[1] = 1;
    for (int i = 2; i <= K; i++){
      f[i] = f[(i-1)] + f[(i-2)];
    }
    return f[K];
  }
}
