public class MyQueue {
    private Stack<Integer> stackin;
    private Stack<Integer> stackout;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stackin = new Stack<Integer>();
        stackout = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackin.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackout.size() == 0) {
            stackin2out();
        }
        return stackout.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stackout.size() == 0) {
            stackin2out();
        }
        return stackout.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stackin.size() + stackout.size()) == 0;
    }
    
    private void stackin2out(){
        while (!stackin.empty()) {
            stackout.push(stackin.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
