//April 27
public class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if(prices == null || prices.length == 0){
            return 0;
        }
        //loop throught the array to find the best benefit
        int curMax = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            //update when find new minimum
            min = Math.min(min, prices[i]);
            //the max benefit can be get since last update of minimum
            curMax = prices[i] - min;
            // only update of the benefit from last udpated minimum price and current price
            max = Math.max(curMax, max);
        }
        return max;
    }
}