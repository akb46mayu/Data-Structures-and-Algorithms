"""
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.


"""

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    # @param {TreeNode} root the root of binary tree
    # @return {TreeNode} the root of the maximum average of subtree
    def findSubtree2(self, root):
        # Write your code here
        if not root:
            return None
            
        results = [None, -sys.maxint, 0] # node val and avg, and num of nodes
        self.findHelper(root, results)
        return results[0]
    
    def findHelper(self, root, results):
        if not root:
            return 0, 0 # sum, num of nodes
        
        sumCurL, numNodesCurL = self.findHelper(root.left, results)
        sumCurR, numNodesCurR = self.findHelper(root.right, results)
        sumTotal = sumCurL + sumCurR + root.val
        numNodes = numNodesCurL + numNodesCurR + 1 
        if sumTotal*results[2] > results[1]*numNodes:
            results[0] = root
            results[1] = sumTotal
            results[2] = numNodes
        return sumTotal, numNodes
