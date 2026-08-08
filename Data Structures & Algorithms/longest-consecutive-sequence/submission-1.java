class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int maxLen = 0;
        int curLen = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1] == nums[i])
                continue;
            if(nums[i+1] - nums[i] == 1){
                curLen++;
                if(curLen > maxLen){
                    maxLen = curLen;
                }
            }else{
                curLen = 0;
            }
        }
        return maxLen+1;

        // 1,2,3,4,6,7,8,9,10
    }
}
