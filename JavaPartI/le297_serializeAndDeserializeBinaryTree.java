/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String splitter = ",";
    private String nn = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.toString();
    }
    private void serialHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nn).append(splitter);
        } else {
            sb.append(root.val).append(splitter);
            serialHelper(root.left, sb);
            serialHelper(root.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(splitter);
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str)); // 
        return deserialHelper(q);
    }
    private TreeNode deserialHelper(Queue<String> q) {
        String temp = q.poll();
        if (temp.equals(nn)) {
            return null;
        } else {
            TreeNode newroot = new TreeNode(Integer.valueOf(temp));
            newroot.left = deserialHelper(q);
            newroot.right = deserialHelper(q);
            return newroot;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
