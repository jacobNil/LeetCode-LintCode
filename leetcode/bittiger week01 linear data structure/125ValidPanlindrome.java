public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        char start;
        char end;
        
        while(left < right) {
            start = s.charAt(left);
            end = s.charAt(right);
            if (!Character.isLetterOrDigit(start)) {
                left++;
            } else if (!Character.isLetterOrDigit(end)) {
                right--;
            } else {
                if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}