class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        // -4 -1 -1 0 1 2
        for(int i = 0; i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int l=i+1,r=nums.length-1;            
            
            while(l<r){    
                int target = nums[i] + nums[l] + nums[r];                
                if(target == 0){
                    List<Integer> mid = new ArrayList<>();
                    mid.add(nums[i]);
                    mid.add(nums[l]);
                    mid.add(nums[r]);
                    result.add(mid);
                    r--;
                    while(l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(target<0){
                    l++;
                }else{
                    r--;
                } 
            }     
        }
        return result;
    }
}
