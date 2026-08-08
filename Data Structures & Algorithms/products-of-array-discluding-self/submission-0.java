class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i=1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int j=1;j<nums.length;j++){
            res[j] = nums[j-1] * res[j-1];
        }
        for(int j=nums.length-1;j>=0;j--){
            
            res[j] = res[j] * i;
            i *= nums[j];
            
        }
        return res;
    }
}  
