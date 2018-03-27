class Solution(object):
  def power(self, a, b):
    """
    input: int a, int b
    return: long
    """
    # write your solution here
    if b == 0:
      return 1
    if a == 0:
      return 0
    if a == 1:
      return 1
    c = self.power(a, b // 2)
    return a * c * c if b % 2 == 1 else c * c
