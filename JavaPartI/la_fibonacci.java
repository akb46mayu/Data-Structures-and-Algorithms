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
// O(1) space (template solution)

public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 0) {
      return 0;
    }
    
    if (K == 1){
      return 1;
    }
    long[] f = new long[2];
    f[1] = 1;
    for (int i = 2; i <= K; i++){
      f[i%2] = f[(i-1)%2] + f[(i-2)%2];
    }
    return f[K%2];
  }
}
// O(1) non template

public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 0) {
      return 0;
    } else if (K == 1) {
      return 1;
    } else {
      long first = 0, second = 1;
      long cur = 0;
      for (int i = 2; i <= K; i++) {
        cur = first + second;
        first = second;
        second = cur;
      }
      return cur;
    }
  }
  
}
