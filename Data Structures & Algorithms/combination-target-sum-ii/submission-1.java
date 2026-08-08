class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> sub = new ArrayList<>();
        dfs(candidates,0,sub,0,target);
        return res;
    }

    public void dfs(int[] candidates, int i, List<Integer> sub, int total, int target){
        if(total == target){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(i >= candidates.length || total > target){
            return;
        }

        sub.add(candidates[i]);
        dfs(candidates,i+1,sub,total + candidates[i],target);

        sub.remove(sub.size() - 1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(candidates,i+1,sub,total,target);
    }
}
