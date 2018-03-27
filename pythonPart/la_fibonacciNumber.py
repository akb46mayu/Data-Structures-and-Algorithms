class Solution(object):
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
