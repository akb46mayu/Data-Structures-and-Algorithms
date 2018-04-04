class Solution(object):
  def dedup(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    
    if array is None:
      return []
    if len(array) <= 2:
      return array
    i = 1
    for j in range(2, len(array)):
      if array[j] == array[i - 1]:
        pass
      else:
        i += 1
        array[i] = array[j]
    return array[:i + 1]
