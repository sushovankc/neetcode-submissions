class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        if(target > nums[nums.length - 1]){
            return binarySearch(0,r-1,target,nums);
        }else if(target<nums[nums.length - 1]){
            return binarySearch(r,nums.length-1,target,nums);
        }else{
            return nums.length - 1;
        }
    }

    public int binarySearch(int l, int r, int target , int[] nums){

        while(l <= r){
            int mid = l + (r - l)/2;

            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
