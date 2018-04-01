class Solution(object):   # Greedy: T = O(n), S = O(1)
  def longest(self, array):
    """
    input: int[] array
    return: int
    """
    # write your solution here

    if array is None or len(array) == 0:
      return 0
    count = 1
    maxval = 1
    n = len(array)
    for i in range(1, n):
      if array[i] > array[i - 1]:
        count += 1
        maxval = max(maxval, count)
      else:
        count = 1
    return maxval

##########################################################
class Solution2(object): # Greedy: T = O(n), S = O(n)
  def longest(self, array):
    """
    input: int[] array
    return: int
    """
    # write your solution here

    if array is None or len(array) == 0:
      return 0
    n = len(array)
    dp = [1] * n
    maxval = 1
    for i in range(1, n):
      if array[i] > array[i - 1]:
        dp[i] = dp[i - 1] + 1
        maxval = max(maxval, dp[i])
      else:
        dp[i] = 1
    return maxval
