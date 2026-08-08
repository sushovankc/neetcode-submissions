class Solution {
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generate(res,digits,"",0);
        return res;

    }

    public void generate(List<String> res,String digits, String cur, int start){
        if(start == digits.length()){
            res.add(cur);
            return;
        }

        String letters = map.get(digits.charAt(start));

        for(int i = 0;i<letters.length();i++){
            generate(res,digits,cur + letters.charAt(i),start + 1);           
        }
        
    }
}
