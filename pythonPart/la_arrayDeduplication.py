class Solution(object):
  def dedup(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    
    if array is None or len(array) <= 1:
      return array
    i = 1
    for j in range(1, len(array)):
      if array[j] == array[j - 1]:
        pass
      else: 
        array[i] = array[j]
        i += 1
    return array[:i]
      
