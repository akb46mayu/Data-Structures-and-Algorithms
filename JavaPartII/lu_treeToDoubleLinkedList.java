/*
convert a tree to double linkedlist (inorder traversal)

*/
import java.util.*;
class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    TreeNode(int key) {
        this.key = key;
    }
}
public class Solution {
    public TreeNode treeToList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] cur = new TreeNode[2];
        convert(root, cur);
        return cur[0];
    }
    
    private void convert(TreeNode root, TreeNode[] cur) {
        if (root == null) {
            return;
        }
        convert(root.left, cur);
        if (cur[0] == null) {
            cur[0] = root;
            cur[1] = root;
        } else {
            TreeNode head = cur[0];
            TreeNode tail = cur[1];
            tail.right = root;
            root.left = tail;
            tail = tail.right;
            cur[1] = root;
        }
        convert(root.right, cur);
    }
    
    
    public static void main(String args[]) {
       TreeNode n1 = new TreeNode(1);
       TreeNode n2 = new TreeNode(2);
       TreeNode n3 = new TreeNode(3);
       TreeNode n4 = new TreeNode(4);
       TreeNode n5 = new TreeNode(5);
       n1.left = n2;
       n1.right = n3;
       n2.left = n4;
       n2.right = n5;
       Solution sol = new Solution();
       TreeNode res = sol.treeToList(n1);
       TreeNode cur = res;
       String out = "";
       while (cur != null) {
           out += cur.key + "-";
           cur = cur.right;
       }
       System.out.println(out);
       
    }
}
