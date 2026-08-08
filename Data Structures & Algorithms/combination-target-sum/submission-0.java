class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums,subset,0,0,target);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> subset, int i, int total, int target){

        if(total == target ){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < total || i>= nums.length){
            return;
        }

        subset.add(nums[i]);
        backtrack(nums,subset,i,total + nums[i], target);

        subset.remove(subset.size() - 1);
        backtrack(nums,subset,i+1,total, target);

    }
}
