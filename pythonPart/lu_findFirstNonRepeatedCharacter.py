# https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
class Solution():
  def findFirst(self, nums):
    if nums is None or len(nums) == 0:
      return -1
    hmap = {}
    for  i, ele in enumerate(nums):
      if ele not in hmap:
        hmap[ele] = [i, 1] # index count
      else:
        hmap[ele][1] += 1
    res = -1
    idx = len(nums) - 1
    for key in hmap.keys():
      if hmap[key][1] == 1 and hmap[key][0] < idx:
        res = key
        idx = hmap[key][0]
    return res
    
    
nums = [ 'c', 'a', 'c', 'd', 'b', 'q']
sol = Solution()
res = sol.findFirst(nums)
print (res)
