class Solution(object):
  def binary_search(self, a, target):
    if a is None or len(a) == 0:
      return -1
    i, j = 0, len(a) -1
    while i <= j:
      k = i + (j - i) // 2
      if a[k] == target:
        return k
      elif a[k] < target:
        i += 1
      else:
        j -= 1
    return -1
    
    
sol = Solution()
a = [1, 4, 5, 6, 7, 9, 10]
target = 7
print (sol.binary_search(a, target))
