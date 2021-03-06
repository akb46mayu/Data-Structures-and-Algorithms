"""
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
Show Company Tags
Show Tags
Show Similar Problems
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):  #use two queues (roughly BFS), a little bit tricky, we appedn the whole level instead of one element
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if root is None:
            return result
        q = [root]
        while q:
            result.append([n.val for n in q])
            newq = []  # this is also the next level queue
            for n in q:
                if n.left:
                    newq.append(n.left)
                if n.right:
                    newq.append(n.right)
            q = newq
        return result
## way 2 (prefered)

from collections import deque

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        q = deque()
        if root == None:
            return res
        q.append(root)
        while q:
            myqsize = len(q)
            levelres = []
            for i in xrange(myqsize):
                popnode = q.popleft()
                levelres.append(popnode.val)
                if popnode.left:
                    q.append(popnode.left)
                if popnode.right:
                    q.append(popnode.right)
            res.append(levelres)
        return res
