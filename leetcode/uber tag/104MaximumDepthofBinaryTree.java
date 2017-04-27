
// april 26, uber age

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //base case
        if(root == null) {return 0;}
        // recursion case
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}