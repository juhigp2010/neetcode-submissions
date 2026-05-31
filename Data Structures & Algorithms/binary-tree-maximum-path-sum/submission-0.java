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
    public int maxPathSum(TreeNode root) {
    int [] maxSum={Integer.MIN_VALUE};
    maxPathSumHelper(root,maxSum);
    return maxSum[0];
    }
    private int maxPathSumHelper(TreeNode root,int[] maxSum)
    {
        if (root == null || maxSum == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(root.left,maxSum),0);
        int rightSum=Math.max(maxPathSumHelper(root.right,maxSum),0);

        int currentpathSum=root.val+leftSum+rightSum;

        maxSum[0] = Math.max(maxSum[0], currentpathSum);

        return root.val+Math.max(leftSum,rightSum);

    }
    
}
