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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> al1= new ArrayList<>();
        if(root==null)
            return al1;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode pop=q.poll();
                if(i==(size-1))
                {
                    al1.add(pop.val);
                }
                    if(pop.left!=null)
                    q.add(pop.left);
                    if(pop.right!=null)
                    q.add(pop.right);
            }
           
        }
        return al1;
    }
}
