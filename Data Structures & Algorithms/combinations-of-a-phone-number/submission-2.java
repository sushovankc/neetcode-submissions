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

        generate(res,digits,new StringBuilder(),0);
        return res;

    }

    public void generate(List<String> res,String digits, StringBuilder cur, int start){
        if(start == digits.length()){
            res.add(cur.toString());
            return;
        }

        String letters = map.get(digits.charAt(start));

        for(int i = 0;i<letters.length();i++){
            cur.append(letters.charAt(i));
            generate(res,digits,cur,start + 1);  
            cur.deleteCharAt(cur.length() - 1);         
        }
        
    }
}
