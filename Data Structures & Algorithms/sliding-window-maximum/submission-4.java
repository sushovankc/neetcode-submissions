class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int j=0;
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) res[j++] = nums[q.peekFirst()];
        }
        return res;        
    }
}

