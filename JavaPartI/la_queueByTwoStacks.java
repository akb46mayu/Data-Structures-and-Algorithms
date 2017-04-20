public class Solution {
  Deque<Integer> stackin;
  Deque<Integer> stackout;
  public Solution() {
    // Write your solution here.
    stackin = new LinkedList<Integer>();
    stackout = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    if (isEmpty() == true) {
       return null;
    }
    stackmove();
    return stackout.pollFirst();
  }
  
  public void offer(int element) {
    stackin.offerFirst(element);
  }
  
  public Integer peek() {
    if (isEmpty() == true) {
       return null;
    }
    stackmove();
    return stackout.peekFirst();
  }
  
  public int size() {
    return stackin.size() + stackout.size();
  }
  
  public boolean isEmpty() {
    return stackin.size() + stackout.size() == 0;
  }
  
  private void stackmove() {
    if (stackout.size() == 0) {
       while (stackin.size() != 0) {
         stackout.offerFirst(stackin.pollFirst());
       }
    }
  }
}

////////////////////////////////////////////
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
    return stackout.empty() ? null : stackout.peek(); // when it is empty, without this ,we will have exceptions
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
