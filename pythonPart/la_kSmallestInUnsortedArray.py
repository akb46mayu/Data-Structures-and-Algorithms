from heapq import heappush, heappop
class Solution(object):
  def kSmallest(self, array, k):
    """
    input: int[] array, int k
    return: int[]
    """
    # write your solution here
    minpq = []
    res = []
    if len(array) == 0 or k <= 0:
      return res
    for ele in array:
      heappush(minpq, ele)
    while len(minpq) != 0 and k > 0:
      res.append(heappop(minpq))
      k -= 1
    return res  


array = [5,23,2,1,4,7,8,9]
k = 3
sol = Solution()
res = sol.kSmallest(array, k)
print res
