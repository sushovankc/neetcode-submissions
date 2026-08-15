class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;

        for(int i = 0; i< matrix.length; i++){
            if(target > matrix[i][col - 1]){
                continue;
            }else if(target < matrix[i][col - 1]){
                int l = 0, r = col - 1;

                while(l<= r){
                    int mid = l + (r - l) / 2;

                    if(target < matrix[i][mid]){
                        r = mid - 1;
                    }else if(target > matrix[i][mid]){
                        l = mid + 1;
                    }else{
                        return true;
                    }
                }
            }else{
                return true;
            }
        }

        return false;
    }
}
