class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,new ArrayList<>(),target,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> set, int target, int ind){
        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }

        if(target < 0 || ind >= nums.length){
            return;
        }
        set.add(nums[ind]);
        backtrack(res,nums,set, target - nums[ind],ind);

        set.remove(set.size()-1);
        backtrack(res,nums,set,target,ind+1);
    }
}
