public class Solution {
  private Deque<Integer> stack;
  private Deque<Integer> mstack;
  public Solution() {
    // write your solution here
    stack = new LinkedList<Integer>();
    mstack = new LinkedList<Integer>();
  }
  
  public int pop() {
    if (stack.size() == 0) {
      return -1;
    }
    int temp = stack.pollFirst();
    if (temp == mstack.peekFirst()) {
      mstack.pollFirst();
    }
    return temp;
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    if (mstack.size() == 0 || element <= mstack.peekFirst()) {
      mstack.offerFirst(element);
    } 
  }
  
  public int top() {
    if (stack.size() == 0 ) {
      return -1;
    }
    return stack.peekFirst();
  }
  
  public int min() {
    return mstack.size() == 0 ? -1 : mstack.peekFirst();
  }
}
