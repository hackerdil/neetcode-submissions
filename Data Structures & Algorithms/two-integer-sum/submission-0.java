class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> differenceNIndex = new HashMap<>();
        for(int i = 0; i <= nums.length-1; i++){
            if(differenceNIndex.containsKey(target-nums[i])){
                 return new int[]{differenceNIndex.get(target-nums[i]), i};
            }
            differenceNIndex.put(nums[i], i);
        }
        return new int[]{0,0};
    }
} 
