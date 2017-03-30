public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(prefix.length(), strs[i].length());
            prefix = prefix.substring(0, length);
            for (int j = 0; j < length; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }
}