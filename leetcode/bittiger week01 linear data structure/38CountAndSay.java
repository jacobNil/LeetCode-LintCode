public class Solution {
    public String countAndSay(int n) {
        // corner case: n = 0
        if (n == 0) return "10";
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = helper(s);
        }
        return s;
    }
    
    private String helper(String s) {
        
        char cur = s.charAt(0);
        int count = 1;
        StringBuilder sBuilder = new StringBuilder();
        // corner case: n is a signle digit number which is not zero
        if (s.length() == 1) {
            sBuilder.append(count);
            sBuilder.append(cur);
            return sBuilder.toString();
        }
        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            if (cur == next) {
                count++;
            } else {
                sBuilder.append(count);
                sBuilder.append(cur);
                count = 1;
                cur = next;
            }
        }
        // deal with the last consecutive digit sequence.
        sBuilder.append(count);
        sBuilder.append(cur);
        return sBuilder.toString();
    }
}