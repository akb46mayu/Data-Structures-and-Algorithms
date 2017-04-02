public class Solution {
  private LinkedList<Integer> stack;
  private LinkedList<Integer> minstack;
  public Solution() {
    // write your solution here
    stack = new LinkedList<Integer>();
    minstack = new LinkedList<Integer>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    } 
    int out = stack.pollFirst();
    if (out == minstack.peekFirst()) {
      minstack.pollFirst();
    }
    return out;    
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    if (minstack.isEmpty() || element <= minstack.peekFirst()) {
      minstack.offerFirst(element);
    }
  }
  
  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    int out = stack.peekFirst();
    return out;
  }
  
  public int min() {
    if (minstack.isEmpty()) {
      return -1;
    }
    return minstack.peekFirst();
  }
}
