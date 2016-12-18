# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """ 
        :type root: TreeNode
        :rtype: List[int]
        """   
        results = []
        self.subPreorderTraversal(root, results)
        return results
    
    def subPreorderTraversal(self, root, results):       
        if root is None:
            return 
        results.append(root.val)
        self.subPreorderTraversal(root.left, results)
        self.subPreorderTraversal(root.right, results)
