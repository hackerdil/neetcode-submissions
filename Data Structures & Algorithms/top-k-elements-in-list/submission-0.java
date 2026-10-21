class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        for(int i : nums){
            freqs.put(i, freqs.getOrDefault(i,0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int i = 0; i< buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }
    
        for(int i : freqs.keySet()){
           buckets[freqs.get(i)].add(i);
        }
        int[] result = new int[k];
        int counter = 0;
        for(int i = buckets.length - 1; i>=0; i-- ){
            if(counter == k){
                break;
            }
            for(int n:buckets[i]){
                result[counter] = n;
                counter++;
            }
            
           
        }
        return result;
    }
}
