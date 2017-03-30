public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            while(nums[start] != val && start < nums.length && start < end) {
                start++;
            }
            while(nums[end] == val && end > 0 && end > start) {
                end--;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
                
        }
        if (nums[start] == val) return start;
        return start+1;
        
    }
}