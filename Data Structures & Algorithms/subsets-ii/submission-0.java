class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> sub, int[] nums, int start){
        res.add(new ArrayList<>(sub));
        for(int i = start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            backtrack(res,sub,nums,i+1);
            sub.removeLast();
        }
    }
}
