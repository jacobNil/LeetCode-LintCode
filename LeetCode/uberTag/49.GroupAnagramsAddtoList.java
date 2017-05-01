//April, 27, uber tage
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new LinkedList<>();
        Arrays.sort(strs);
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();  // when should the angle square be filled??
        for (String curr: strs) {
            char[] currArray= curr.toCharArray();
            Arrays.sort(currArray);
            String key = String.valueOf(currArray);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new LinkedList<String>());
            }
            anagrams.get(key).add(curr);
        }
        return new ArrayList<List<String>>(anagrams.values());
    }
}



public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //corner case
        List<List<String>> result = new LinkedList<>();
        if(strs == null | strs.length == 0) {
            return result;
        }
        
        //use hashmap to classifiy each string words
        Arrays.sort(strs);
        Map<String, List<String>> anagram = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            if(anagram.containsKey(String.valueOf(curr))) {
                anagram.get(String.valueOf(curr)).add(strs[i]);
            } else {
                List<String> currAna = new LinkedList<>();
                currAna.add(strs[i]);
                anagram.put(String.valueOf(curr), currAna);
            }
        }
        // use the alls the value in the map to build the result
        result = new ArrayList<List<String>>(anagram.values());
        return result;
        
    }
}