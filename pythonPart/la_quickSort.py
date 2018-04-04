from random import *
class Solution(object):
  def quickSort(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    
    if array is None or len(array) == 0:
      return array
    self.sortHelper(array, 0, len(array) - 1)
    return array
    
  def sortHelper(self, array, left, right):
    if left >= right:
      return
    pivotidx = self.partition(array, left, right)
    self.sortHelper(array, left, pivotidx - 1)
    self.sortHelper(array, pivotidx + 1, right)
    
    
  def partition(self, array, left, right):
    if left >= right:
      return left
    idx = randint(left, right)
    pval = array[idx]
    array[idx], array[right] = array[right], array[idx]
    i = left
    j = right - 1
    while i <= j:
      if array[i] < pval:
        i += 1
      else:
        array[i], array[j] = array[j], array[i]
        j -= 1
    array[i], array[right] = array[right], array[i]
    return i
