"""
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
"""

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        carry = 1
        for i in reversed(range(len(digits))):
            digits[i] += carry
            carry = digits[i]/10
            digits[i] = digits[i]%10
        if carry == 1:
            digits = [1] + digits
        return digits
