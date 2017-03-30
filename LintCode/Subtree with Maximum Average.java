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
     *for record multilevel information of helper function
     */
    private class ResultType {
        public int sum;
        public int count;

        public ResultType (int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    private TreeNode subtree = null;
    private ResultType maxAverage = null;

    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        helper(root);
        return subtree;
    }

    private ResultType helper(TreeNode root) {
        ResultType result = new ResultType(0, 0);
        if (root == null) {
            return result;
        }
        // recursion case
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        result.sum = left.sum + right.sum + root.val;
        result.count = left.count + right.count + 1;

        if (maxAverage == null ||
            maxAverage.sum * result.count < result.sum * maxAverage.count) {
                maxAverage = result;
                subtree = root;
            }
        return result;
    }


}
