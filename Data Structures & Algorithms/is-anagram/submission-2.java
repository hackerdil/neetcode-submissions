class Solution {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> string1Chars = new HashMap<>();
        Map<Character, Integer> string2Chars = new HashMap<>();
        if(s.length() != t.length()) {return false;}
        for(char c: s.toCharArray()){
            mapFrequencyAdder(string1Chars, c);
        }
        for(char c: t.toCharArray()){
           mapFrequencyAdder(string2Chars, c);
        }
        return string1Chars.equals(string2Chars);

    }
    public void mapFrequencyAdder(Map<Character, Integer> map, Character c){
        if(map.containsKey(c)){
             map.put(c ,map.get(c) + 1);
        }
        else{
            map.put(c,1);
          
        }

    }
}
