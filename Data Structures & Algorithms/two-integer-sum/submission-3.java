class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int current = target - nums[i];

            if(map.containsKey(current)){
                return new int[]{map.get(current),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
        // while(l <= r){
        //     int sum = nums[l] + nums[r];
        //     if(sum == target){
        //         return new int[]{l,r};
        //     }else if(sum < target){
        //         l++;
        //     }else{
        //         r--;
        //     }
        // }

        // return new int[2];
    }
}
