class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        Arrays.sort(arrS);
        String newS = new String(arrS);
        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);
        String newT = new String(arrT);

        if(newS.equals(newT)) return true;

        return false;
    }
}
