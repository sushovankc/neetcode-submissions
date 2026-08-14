class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0;i<position.length;i++){
            int[] temp = new int[]{position[i],speed[i]};
            list.add(temp);
        }

        list.sort((a, b) -> Integer.compare(b[0], a[0]));

        for(int[] car : list){
            int pos = car[0];
            int spd = car[1];
            double time = (double)(target - pos) / spd;

            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
