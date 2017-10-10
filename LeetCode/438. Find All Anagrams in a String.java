/**
* O(n*m) solution is easy. Just loop throught string s to find every substring with length p.length().
* Then check if this string is a anagram of p.
* This will be O(n*m), because check if a substring of s is an anagram of p will take linear time.
* 
* O(n) solution is hard. 
* Use a sliding windwo with length of p.length(). When every time slide the window, only use add the new element and remove an
* old element. 
* Use a int array of 256(length of extended ascii code) to record the frequency of every letter in string p.
* Use a count, which is the length of string p at the beginning to record the number of same letter an anagram should have.
* Becarefull about when adding and removing a new element.
*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int[] hash = new int[256];
        
        for(char c : p.toCharArray()) {
            hash[c]++;
        }
        int count = p.length();
        for(int i = 0; i < s.length(); i++) {
            // add a new element, if adding it can reduce the difference between current substring and p
            if(hash[s.charAt(i)] > 0) {
                count--;
            }
            hash[s.charAt(i)]--;
            if((i - p.length()) >=0) {
                if (hash[s.charAt(i-p.length())] >= 0) {
                    count++;
                }
                // 
                hash[s.charAt(i-p.length())]++;
            } 
            
            if (count == 0) {
                result.add(i-p.length() + 1);
            }
        }
        return result;
    }
}