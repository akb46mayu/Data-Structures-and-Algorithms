class Solution(object):  # T = O(k), S = O(K)
  def fibonacci(self, K):
    """
    input: int K
    return: long
    """
    # write your solution here
    if K <= 0:
      return 0
    if K == 1:
      return 1
    f = [0 for i in range(K + 1)]
    f[0], f[1] = 0, 1
    for i in range(2, K + 1):
      f[i] = f[i - 1] + f[i - 2]
    return f[K]

  
class Solution2(object): # T = O(k), S = O(1)
  def fibonacci(self, K):
    """
    input: int K
    return: long
    """
    # write your solution here
    if K <= 0:
      return 0
    if K == 1:
      return 1
    f = [0, 1]
    for i in range(2, K + 1):
      f[i % 2] = f[(i - 1) % 2] + f[(i - 2) % 2]
    return f[i % 2]

  
# recursion
class Solution(object):
  def __init__(self):
    self.dict = {}
    
  def fibonacci(self, K):
    
    """
    input: int K
    return: long
    """
    # write your solution here
    if K in self.dict:
      return self.dict[K]
    if K <= 0:
      self.dict[0] = 0
      return 0
    if K == 1:
      self.dict[1] = 1
      return 1
    
    res = self.fibonacci(K - 1) + self.fibonacci(K - 2)
    self.dict[K] = res
    return res
     
    
