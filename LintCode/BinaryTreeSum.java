// binary tree sum: solution 1

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(root, paths , path);
        
        for (List<Integer> route: paths) {
            int sum = 0;
            for (int val: route) {
                sum += val;
            }
            if (sum == target) {
                result.add(new ArrayList<Integer>(route));
            }
        }
        return result;
    }
    
    private void helper (TreeNode root, 
                         List<List<Integer>> paths,
                         List<Integer> path) {
                             
        path.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        
        if (root.left != null) {
            helper(root.left, paths, path);
        }
        if (root.right != null) {
            helper(root.right, paths, path);
        }
        path.remove(path.size()-1);
    }
}
