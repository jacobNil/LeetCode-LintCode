public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int power = 1;
        for(int i = s.length()-1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1)*power;
            power *= 26;
        }
        return result;
    }
}