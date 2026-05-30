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
    public int goodNodes(TreeNode root) {
        if(root==null)
        return 0;

        return goodTreeNodes(root,root.val);
        

    }
    private int goodTreeNodes(TreeNode root,int max)
    {
        if(root==null)
            return 0;
            int count=0;
        if(root.val>=max)
        {count++;
        max=root.val;}
       count +=  goodTreeNodes(root.left,max);
       count+= goodTreeNodes(root.right,max);

        return count;
    }
}
