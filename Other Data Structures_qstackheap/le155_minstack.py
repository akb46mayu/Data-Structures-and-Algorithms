"""
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
"""
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

class MinStack(object):  # do not save space 

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minStack = []
        self.stack = []
        
    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(x)        
        if self.minStack:
            if self.minStack[-1] > x:
                self.minStack.append(x)
            else:
                self.minStack.append(self.minStack[-1])
        else:
            self.minStack.append(x)
                       
    def pop(self):
        """
        :rtype: void
        """
        self.stack.pop()
        self.minStack.pop()
        
    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1]

class MinStack2(object):  # save space

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []
        
    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if len(self.stack) == 0 or x <= self.minStack[-1]:
            self.minStack.append(x)
        
        self.stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if self.stack[-1] == self.minStack[-1]:
            self.minStack.pop()
        return self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1]
