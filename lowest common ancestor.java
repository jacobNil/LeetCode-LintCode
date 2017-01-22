// lowest common ancestor of binary tree
// use divide conquer and recursion

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        
        if (root == null) {
            return root;
        }
        if (A == null || B == root) {
            return B;
        }
        if (B == null || A == root) {
            return A;
        }
        
        // divede
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        // conquer or merge
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left == A && right ==B || right == A && left == B) {
            return root;
        }
        return null;
    }
}
