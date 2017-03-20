"""
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if not root:
            return []
        path = []
        paths = []
        self.btreeHelper(root, path, paths)
        return paths
        
    def btreeHelper(self, root, path, paths):
        if not root:
            return
        path.append(str(root.val))
        if not root.left and not root.right:
            paths.append('->'.join(path))
            path.pop() # is this pop for printing result usage?
            return 
        self.btreeHelper(root.left, path , paths)
        self.btreeHelper(root.right, path, paths)
        path.pop() # is this pop for traverse usage?
