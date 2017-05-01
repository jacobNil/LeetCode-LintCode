
// april 30, uber tage

class Solution {
    public void reverseWords(char[] s) {
        // corner case
        if(s == null || s.length <= 1) {
            return;
        }
        System.out.println(s);
        // reverse the whole string
        reverse(s, 0, s.length-1);
        // reverse each words according to space
        int start = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                reverse(s, start, i-1);
                start = i + 1;
            }
            if(i == (s.length - 1)) {
                reverse(s, start, i);
                System.out.println("reverse final");
            }
        }
        
        return;
    }
    
    private void reverse(char[] s, int start, int end) {
        if(start >= end) {
            return;
        }
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        return;
    }
}
