class Solution(object):  ## O(n)
  def getRange(self, root, min, max):
    """
    input: TreeNode root, int min, int max
    return: List<Integer>
    """
    # write your solution here
    res = []
    self.rangeHelper(root, min, max, res)
    return res
  
  def rangeHelper(self, root, min, max, res):
    if root is None:
      return
    self.rangeHelper(root.left, min, max, res)
    if root.val >= min and root.val <= max:
      res.append(root.val)
    self.rangeHelper(root.right, min, max, res)

    
    
    
    
class Solution2(object): # with prunning, T = O(logn)
  def getRange(self, root, min, max):
    """
    input: TreeNode root, int min, int max
    return: List<Integer>
    """
    # write your solution here
    res = []
    self.rangeHelper(root, min, max, res)
    return res
    
  def rangeHelper(self, root, min, max, res):
    if root is None:
      return res
    if root.val > min:
      self.rangeHelper(root.left, min, max, res)
    if root.val >= min and root.val <= max:
      res.append(root.val)
    if root.val < max:
      self.rangeHelper(root.right, min, max, res)
