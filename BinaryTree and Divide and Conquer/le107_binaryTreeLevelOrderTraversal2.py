"""
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
Show Tags
Show Similar Problems


"""



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        curq, nextq = [root], []
        result = []
        ans = []
        while curq:
            result.append([nd.val for nd in curq])
            nextq = []
            for nd in curq:
                if nd.left:
                    nextq.append(nd.left)
                if nd.right:
                    nextq.append(nd.right)
            curq = nextq
        while result:
            ans.append(result.pop())
        return ans
            
