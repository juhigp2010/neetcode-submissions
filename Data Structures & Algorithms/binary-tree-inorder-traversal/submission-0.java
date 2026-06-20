/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root==null)
        return al;
        inOrderHelper(al,root);
        return al;

    }
    private void inOrderHelper(List<Integer> al,TreeNode root)
    {
        if(root==null)
        return;
        inOrderHelper(al,root.left);
        al.add(root.val);
        inOrderHelper(al,root.right);

    }
}