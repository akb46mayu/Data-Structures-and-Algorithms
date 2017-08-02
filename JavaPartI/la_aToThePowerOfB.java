//

public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0){
      return 1;
    }
    if (a == 0){
      return 0;
    }
    long half = power(a, b / 2);
    return b % 2 == 0 ? half * half: a * half * half;
  }
}
///////////////////

public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (a == 0) {
      return 0;
    }
    if (b == 0) {
      return 1;
    }
    long temp = power(a, b / 2);
    if (b % 2 == 0) {
      return temp * temp;
    } else {
      return temp * temp * a;
    }
  }
}


///////////////////
public class Solution { // different coding style, 
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0) {
      return 1;
    }
    if (b == 1) { // corner case is easier to remember
      return a;
    }
    long temp = power(a, b / 2);
    if (b % 2 == 0) {
      return temp * temp;
    } else {
      return (temp * temp) * a;
    }
  }
}
