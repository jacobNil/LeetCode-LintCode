// april 26, uber tage
public class Solution {
    public boolean isAnagram(String s, String t) {
        // corner case
        if(s == null || t == null) return true;
        if(s.length() == 0 || s.length() == 0) return true;
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> frequency = new HashMap<>();
        // build frequency map based on one string
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            frequency.put(curr, frequency.getOrDefault(curr, 0)+1);
        }
        // verify the other string
        for(int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if(frequency.getOrDefault(curr, 0) > 0) {
                frequency.put(curr, frequency.get(curr)-1);
            } else {
                return false;
            }
        }
        // verify nothing left in the table
        for(Map.Entry<Character, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
        
        
    }
}