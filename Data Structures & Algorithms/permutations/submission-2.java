class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,new ArrayList<>(),0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> per, int ind){
        if(per.size() == nums.length){
            res.add(new ArrayList<>(per));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(!per.contains(nums[i])){
                per.add(nums[i]);
                backtrack(res,nums,per,ind+1);
                per.remove(per.size() - 1);
            }

        }
    }
}
