public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) return result;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return result;
            int target = 0 - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            
            while(high > low) {
                if (nums[high] + nums[low] > target) {
                    high--;
                } else if (nums[high] + nums[low] < target) {
                    low++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                    while (high > low && nums[high] == nums[high-1]) high--;
                    high--;
                    while (high > low && nums[low] == nums[low+1]) low++;
                    low++;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i+1] == nums[i]) {
                i++;
            }
            
        }
        return result;
    }
}