#### without return value

class Solution(object):
  def mergeSort(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    
    if array is None or len(array) == 0:
      return array
    copy = [0] * len(array)
    self.mergeHelper(array, copy, 0, len(array) - 1)
    return array
  
  def mergeHelper(self, array, copy, i, j):
    if i == j:
      return
    m = i + (j - i) // 2
    self.mergeHelper(array, copy, i, m)
    self.mergeHelper(array, copy, m + 1, j)
    self.merge(array, copy, i, m, j)
    
    
  def merge(self, array, helper, left, m, right):
    for i in range(left, right + 1):
      helper[i] = array[i]
    i = left
    j = m + 1
    k = left
    while i <= m and j <= right:
      if helper[i] < helper[j]:
        array[k] = helper[i]
        i += 1
      else:
        array[k] = helper[j]
        j += 1
      k += 1
    while i <= m:
      array[k] = helper[i]
      k += 1
      i += 1


### with return value
class Solution(object):  
  def mergeSort(self, array):
    """
    input: int[] array
    return: int[]
    """
    # write your solution here
    
    if array is None or len(array) == 0:
      return array
    return self.mergeHelper(array, 0, len(array) - 1)
   
  
  def mergeHelper(self, array, i, j):
    if i == j:
      out = [array[i]]
      return out
    m = i + (j - i) // 2
    leftseg = self.mergeHelper(array, i, m)
    rightseg = self.mergeHelper(array, m + 1, j)
    out = self.merge(leftseg, rightseg)
    return out
    
  def merge(self, left, right):
    n1 = len(left)
    n2 = len(right)
    n = n1 + n2
    out = [0] * n
    i, j = 0, 0
    k = 0
    while i < n1 and j < n2:
      if left[i] < right[j]:
        out[k] = left[i]
        i += 1
      else:
        out[k] = right[j]
        j += 1
      k += 1
    while j < n2:
      out[k] = right[j]
      k += 1
      j += 1
    while i < n1:
      out[k] = left[i]
      i += 1
      k += 1
    return out
