"""
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

"""


"""
each element in stack are integers
"""

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        operators = ['+','-','*','/']
        stack = []
        for x in tokens:
            if x not in operators:
                stack.append(int(x))
            else:
                op1 = stack.pop()
                op2 = stack.pop()
                ele = self.operations(op1, op2, x)
                stack.append(ele)
        return stack[0]
    def operations(self, op1, op2, operand):

        if operand == '+':
            out = op1 + op2
        elif operand == '-':
            out = op2 - op1
        elif operand == '*':
            out = op1 * op2
        else:
            out = int((1.0*op2/op1))
        return out
