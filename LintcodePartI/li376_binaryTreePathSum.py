"""
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]


"""


"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
class Solution:
    # @param {TreeNode} root the root of binary tree
    # @param {int} target an integer
    # @return {int[][]} all valid paths
    def binaryTreePathSum(self, root, target):
        # Write your code here
        if not root:
            return []
        path = []
        paths = []
        self.sum0 = 0
        self.btHelper(root, path, target, paths)
        return paths
        
    def btHelper(self, root, path, target, paths):
        if root is None:
            return
        # node is non empty
        path.append(root.val)
        self.sum0 += root.val
        if not root.left and not root.right:
            if self.sum0 == target:
                paths.append(path[:])   # be careful here, you should append an object not the reference (append path will be ref)
                self.sum0 -= root.val 
                path.pop()
            else:            
                self.sum0 -= root.val
                path.pop()
            return    
        self.btHelper(root.left, path, target, paths)
        self.btHelper(root.right, path, target, paths)
        self.sum0 -= root.val
        path.pop()
 
class Solution:  # the same method as above, with sum0 as a parameter
    # @param {TreeNode} root the root of binary tree
    # @param {int} target an integer
    # @return {int[][]} all valid paths
    def binaryTreePathSum(self, root, target):
        # Write your code here
        if not root:
            return []
        path = []
        paths = []
        sum0 = 0
        self.btHelper(root, path, target, sum0, paths)
        return paths
        
    def btHelper(self, root, path, target, sum0, paths):
        if root is None:
            return
        # node is non empty
        path.append(root.val)
        sum0 += root.val
        if not root.left and not root.right:
            if sum0 == target:
                paths.append(path[:])  
                sum0 -= root.val 
                path.pop()
            else:            
                sum0 -= root.val
                path.pop()
            return    
        self.btHelper(root.left, path, target, sum0, paths)
        self.btHelper(root.right, path, target, sum0, paths)
        sum0 -= root.val
        path.pop()
