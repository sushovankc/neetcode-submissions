class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        // for(int[] nums : matrix){
        //     int l = 0, r = nums.length-1;
        //     while(l<=r){
        //         int mid = (r+l)/2; // l + (r-l)/2
        //         if(nums[mid] < target){
        //             l = mid + 1;
        //         }else if(nums[mid] > target){
        //             r = mid - 1;
        //         }else{
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int i = 0, j = matrix[0].length-1;
        
        while(i < matrix.length && j>=0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
