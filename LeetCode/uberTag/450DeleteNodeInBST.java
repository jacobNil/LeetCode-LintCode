// april 30, uber tage

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
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root == null) {
            return root;
        }
        // key is in the left subtree
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // key in the right subtree
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        // current root is key
        if(root.val == key) {
            // node contains key value has no child
            if(root.left == null && root.right == null) {
                return null;
            }
            // node contains key value has one child
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            // node has both children: use 1)min value of right subtree or 2)max of left subtree
            TreeNode minNode = minNodeOfTree(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
            return root;
        }
        return root;
    }
    // helper funtion can find the min value of a bst.
    private TreeNode minNodeOfTree(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
