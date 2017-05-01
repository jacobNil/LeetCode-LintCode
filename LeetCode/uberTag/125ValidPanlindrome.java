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





// April 26
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            // make sure the left part is number or digit
            while(start < end) {
                left = s.charAt(start);
                
                if(Character.isLetterOrDigit(left)) {
                    break;
                }
                start++;
            }
            // make sure the right part is number or digit
            while(start < end) {
                right = s.charAt(end);
                if(Character.isLetterOrDigit(right)) {
                    break;
                }
                end--;
            }
            //compare
            if(start >= end) {
                continue;
            }
            if(Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
