class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums.length <2){
            return new int[0];
        }

        int[] result = new int[2];
        Map<Integer,Integer> track = new HashMap<>();

        for(int j=0;j<nums.length;j++){
            int curTarget = target - nums[j];
            if(track.containsKey(curTarget)){
                
                result[0] = track.get(curTarget);
                result[1] = j;
                return result;
            }
            track.put(nums[j],j);
        }

        return result;
    }
}
