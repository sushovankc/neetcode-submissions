class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] arrS = s.toCharArray();
        Arrays.sort(arrS);
        String newS = new String(arrS);
        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);
        String newT = new String(arrT);

        return newS.equals(newT);
    }
}
