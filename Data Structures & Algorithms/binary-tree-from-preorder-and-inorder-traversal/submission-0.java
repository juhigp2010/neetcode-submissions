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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        return buildTreeHelper(preorder,inorder,0,n-1);
    }
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int low,int high)
    {
        if(low>high)
        return null;
        TreeNode root=new TreeNode(preorder[preIndex++]);
        int inIndex=low;
        for(int i=low;i<=high;i++)
        {
            if(inorder[i]==root.val)
            {inIndex=i;
            break;}
        }
        root.left=buildTreeHelper(preorder,inorder,low,inIndex-1);
        root.right=buildTreeHelper(preorder,inorder,inIndex+1,high);
        return root;
    }
}
