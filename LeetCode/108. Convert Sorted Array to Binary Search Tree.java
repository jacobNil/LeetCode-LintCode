/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//////////////////////////////////////////////////////////////////////////////////////////
// solution1
//////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        if(nums.length == 1) {
            return new TreeNode(nums[0]);    
        }
        if(nums.length == 2) {
            TreeNode result = new TreeNode(nums[0]);
            result.right = new TreeNode(nums[1]);
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        addSortedArrayToBST(nums, root, start, mid-1);
        addSortedArrayToBST(nums, root, mid+1, end);
        return root;
    }
    
    private void addSortedArrayToBST(int[] nums, TreeNode root, int start, int end) {
        if(start == end) {
            addToBST(root, nums[start]);
            return;
        }
        // dead loop will happen when the interval is like (2, 3)
        if ((start + 1) == end) {
            addToBST(root, nums[start]);
            addToBST(root, nums[end]);
            return;
        }
        int mid = start + (end-start)/2;
        addToBST(root, nums[mid]);
        addSortedArrayToBST(nums, root, start, mid-1);
        addSortedArrayToBST(nums, root, mid+1, end);
    }
    
    
    private void addToBST(TreeNode root, int num) {
        while(true) {
            if(root.val < num) {
                if (root.right != null) {
                    root = root.right;
                } else if (root.right == null) {
                    root.right = new TreeNode(num);
                    return;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                } else if (root.left == null) {
                    root.left = new TreeNode(num);
                    return;
                }
            } 
        }
    }
}




//////////////////////////////////////////////////////////////////////////////////////////
// solution 2
// much shorter and cleaner
//////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
            
        int start = 0;
        int end = nums.length - 1;

        return addToBST(nums, start, end);
    }
    
    private TreeNode addToBST(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        
        if(start > end) {
            return null;
        }
        // if start < end
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = addToBST(nums, start, mid-1);
        root.right = addToBST(nums, mid+1, end);
        return root;
    }
}








