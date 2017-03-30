public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new LinkedList<>();
        if (nums == null || nums.length == 0) return ranges;
        int cur = nums[0];
        String range = Integer.toString(cur);
        // be care full with this case
        if (nums.length == 1) {
            ranges.add(range);
            return ranges;
        }
        for (int i = 1; i < nums.length; i++) {
            while(i < nums.length && nums[i] == cur + 1) {
                cur++;
                i++;
            }
            // when this range has only one number
            if (cur == Integer.parseInt(range)) {
                    ranges.add(range);
                } else { // when this range has more than one number
                    range += "->" + Integer.toString(cur);
                    ranges.add(range);
                }
            // determine if the process has ended
            if (i < nums.length - 1) {
                cur = nums[i];
                range = Integer.toString(cur);
            } else if ( i == nums.length - 1) {
                ranges.add(Integer.toString(nums[nums.length - 1]));
            } 
        }
        return ranges;
    }
}