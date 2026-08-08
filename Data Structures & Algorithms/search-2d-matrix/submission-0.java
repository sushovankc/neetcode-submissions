class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] nums : matrix){
            int l = 0, r = nums.length-1;
            while(l<=r){
                int mid = (r+l)/2; // l + (r-l)/2
                if(nums[mid] < target){
                    l = mid + 1;
                }else if(nums[mid] > target){
                    r = mid - 1;
                }else{
                    return true;
                }
            }
        }

        return false;
    }
}
