"""
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.

"""


"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution: # divide and conquer
    # @param {TreeNode} root the root of binary tree
    # @return {TreeNode} the root of the minimum subtree
    def findSubtree(self, root):
        # Write your code here
        if not root:
            return None
        
        minsum = sys.maxint
        ans = [None, minsum]
        self.findHelper(root, ans)
        return ans[0]
        
    def findHelper(self, root, ans): # sum including the cur node
        if not root:
            return 0
        leftmin = self.findHelper(root.left, ans)
        rightmin = self.findHelper(root.right, ans)
        curmin = leftmin + rightmin + root.val
        minsum = ans[1]
        if curmin < minsum:
            ans[1] = curmin
            ans[0] = root
        return curmin
