//april 26, uber tag
public class Solution {
    public boolean canPermutePalindrome(String s) {
        // corner case
        if(s == null) return false;
        if(s.length() == 1) return true;
        // build frequency table
        Map<Character, Integer> frequency = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0)+1);
        }
        // verify by checkfrequency table---> only one letter can have odd frequency
        int oddCount = 0;
        for(Map.Entry<Character, Integer> curr : frequency.entrySet()) {
            if((curr.getValue() & 1) == 1) {
                oddCount++;
            }
            if(oddCount > 1) return false;
        }
        return true;
        
    }
}