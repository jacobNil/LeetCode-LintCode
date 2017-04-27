// april 26

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // corner case
        if(pattern == null || str == null) return false;
        if(pattern.length() == 0 && str.length() == 0) return true;
        //split string to form a strng array
        String[] words = str.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        // check with HashMap to see if pattern match
        Map<Character, String> bijection = new HashMap<>();
        Set<String> element = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            if(bijection.containsKey(pattern.charAt(i))) {
                if(!bijection.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if(element.contains(words[i])) {
                    return false;
                }
                bijection.put(pattern.charAt(i), words[i]);
                element.add(words[i]);
            }
        }
        return true;
    }
}