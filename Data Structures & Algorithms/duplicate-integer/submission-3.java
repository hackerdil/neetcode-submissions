class Solution {
    HashSet<Integer> numbers = new HashSet<>();
    public boolean hasDuplicate(int[] nums) {
        for(int number:nums){
            if(!numbers.add(number)){
                return true;
            }
            
        }
        return false;
    }
}