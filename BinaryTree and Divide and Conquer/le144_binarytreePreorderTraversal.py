# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object): #  recursion and traverse
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
        
class Solution2(object): # use iteration (non-recursion) and stack
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        results = []
        stack = []
        if root is None:
            return results
        stack.append(root)
        while stack:            
            cur = stack.pop()
            results.append(cur.val)
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
        return results
    
class Solution3: # recursion- divide and conquer
    """
    @param root: The root of binary tree.
    @return: Preorder in ArrayList which contains node values.
    """
    def preorderTraversal(self, root):
        # write your code here
        
        result = []
        if not root:
            return result
        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)
        result = [root.val] + left + right
        return result
