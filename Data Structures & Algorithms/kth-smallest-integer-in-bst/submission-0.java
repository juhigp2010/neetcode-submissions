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
      int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;}
        int left = kthSmallest(root.left, k);
    if (left != -1) {
        return left; // If found in the left, pass it up!
    }
    
    // 2. Process current node
    count++;
    if (count == k) {
        return root.val;
    }
    
    // 3. Search in the right subtree
    return kthSmallest(root.right, k);
    } 
}
