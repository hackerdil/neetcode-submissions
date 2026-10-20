class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String s: strs){
            String freq = frequencyString(s);
            if(!result.containsKey(freq)){
                result.put(freq, new LinkedList<>());
            }
            result.get(freq).add(s);

        }
        return new ArrayList<> (result.values());
    }
     public String frequencyString(String s){
        int[] freqArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            freqArr[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(freqArr);
     }

}
