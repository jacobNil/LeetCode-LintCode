// April 26
public class Solution {
    public int romanToInt(String s) {
        //corner case
        if(s == null || s.length() == 0) {
            return 0;
        }
        //build a hasp map from roman character to integer value
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('M', 1000);
        roman.put('D', 500);
        roman.put('C', 100);
        roman.put('L', 50);
        roman.put('X', 10);
        roman.put('V', 5);
        roman.put('I', 1);
        
        int result = roman.get(s.charAt(s.length()-1));
        for(int i = s.length()-2; i>=0; i--) {
            if (roman.get(s.charAt(i)) >= roman.get(s.charAt(i + 1))) {
                result += roman.get(s.charAt(i));
            } else {
                result -= roman.get(s.charAt(i));
            }
        }
        return result;
    }
}