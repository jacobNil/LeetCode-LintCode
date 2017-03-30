public class GroupAnagrams {
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