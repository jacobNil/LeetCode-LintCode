// recursion to flatten binary tree to linked list

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        helper(root);
        
    }
    
    private void helper (TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            helper(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            helper(root.right);
        }
        if (root.left != null && root.right != null) {
            findRightest(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
            helper(root.right);
        }
    }
    
    private TreeNode findRightest (TreeNode root) {
        if (root.right == null) {
            return root;
        } else {
            return findRightest(root.right);
        } 
    }
}





