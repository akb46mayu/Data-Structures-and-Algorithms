public class Solution {
  private Stack<Integer> stackin;
  private Stack<Integer> stackout;
  
  public Solution() {
    // Write your solution here.
    stackin = new Stack<Integer>();
    stackout = new Stack<Integer>();
  }
  
  public Integer poll() {
    if (stackout.size() == 0) {
      stackin2out();
    }
    return stackout.empty() ? null : stackout.pop();
  }
  
  public void offer(int element) {
    stackin.push(element);
  }
  
  public Integer peek() {
    if (stackout.size() == 0) {
      stackin2out();
    }
    return stackout.empty() ? null : stackout.peek();
  }
  
  public int size() {
    return stackin.size() + stackout.size();
  }
  
  public boolean isEmpty() {
    return (stackin.size() + stackout.size()) == 0;
  }
  
  private void stackin2out() {
    while (!stackin.empty()) {
      stackout.push(stackin.pop());
    }
  }
}
