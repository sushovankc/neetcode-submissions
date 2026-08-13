class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()) return false;
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }else if(c == '}' && topChar != '{'){
                    return false;
                }else if(c == ']' && topChar != '['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
