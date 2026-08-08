class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> sub, int[] nums){
        if(sub.size() == nums.length){
            res.add(new ArrayList<>(sub));
        }

        for(int i = 0;i<nums.length;i++){
            if(!sub.contains(nums[i])){
                sub.add(nums[i]);
                backtrack(res,sub,nums);
                sub.remove(sub.size()-1);
            }
        }
    }
}
