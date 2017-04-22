// April 22
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
    
    /*
    a path sum is the sum of a subsequence.
    The subsequence fron i+1 to j inclusively can be considered as sum[j] - sum[i].
    */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return dfsHelper(root, sum, 0, preSum);
        
    }
    
    private int dfsHelper(TreeNode root, int target, int current, Map<Integer, Integer> preSum) {
        int count = 0;
        // corner case
        if(root == null) {
            return count;
        }
        
        current += root.val;
        
        if (preSum.containsKey(current - target)) {
            count += preSum.get(current - target);
        }
        
        if(preSum.containsKey(current)) {
            preSum.put(current, preSum.get(current) + 1);
        } else {
            preSum.put(current, 1);
        }
        
        
        int sum = count + dfsHelper(root.left, target, current, preSum) + dfsHelper(root.right, target, current, preSum);
        preSum.put(current, preSum.get(current) - 1);
        return sum;
        
    }
}