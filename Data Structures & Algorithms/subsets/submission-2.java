class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,new ArrayList<>(),0);
        return res;
    }   

    public void backtrack(List<List<Integer>> res , int[] nums, List<Integer> sub, int start){
        res.add(new ArrayList<>(sub));

        for(int i = start; i< nums.length;i++){
            
                sub.add(nums[i]);
                backtrack(res,nums,sub,i+1);
                sub.remove(sub.size() - 1);
            
        }
    }
}
