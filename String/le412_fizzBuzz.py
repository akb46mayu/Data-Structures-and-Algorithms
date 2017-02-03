"""


Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
or numbers which are multiples of both three and five output “FizzBuzz”.
"""

class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        out = []
        for i in range(n):
            if (i+1)%3 == 0 and (i+1)%5 ==0:
                out.append("FizzBuzz")
            elif (i+1)%3 == 0:
                out.append("Fizz")
            elif (i+1)%5 ==0:
                out.append("Buzz")
            else:
                out.append(str(i+1))
        return out
