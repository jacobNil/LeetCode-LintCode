// april 30 uber tag
c class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if(strings == null || strings.length == 0) {
            return result;
        }
        Map<String, List<String>> shift = new HashMap<>();
        
        // calculate the shift for each string
        for(int i = 0; i < strings.length; i++) {
            String key = getStringCode(strings[i]);
            if(!shift.containsKey(key)) {
                shift.put(key, new LinkedList<String>());
            }
            shift.get(key).add(strings[i]);
            
        }
        result = new ArrayList<List<String>>(shift.values());
        return result;
    }
    
    private String getStringCode(String string) {
        if(string.length() == 1) {
            return "0";
        }
        String code = "";
        for(int i = 0; i < string.length()-1; i++) {
            int c = (26 + (string.charAt(i+1) - string.charAt(i)))%26;
            if(c < 10) {
                code = code + "0" + c;
            } else {
                code += c;
            }
        }
        return code;
    }
}
