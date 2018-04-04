class Solution(object):
  def solve(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here

    if array is None or len(array) <= 1:
      return array
    n = len(array)
    for i in range(0, n - 1):
      idx = i
      minval = array[i]
      for j in range(i + 1, n):
        if array[j] < minval:
          minval = array[j]
          idx = j
      array[i], array[idx] = array[idx], array[i]
    return array
