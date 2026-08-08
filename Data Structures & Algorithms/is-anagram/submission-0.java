class Solution {
    public boolean isAnagram(String s, String t) {
            char[] arrS = s.toCharArray();
            char[] arrT = t.toCharArray();

            Arrays.sort(arrS);
            Arrays.sort(arrT);

            String newS = new String(arrS);
            String newT = new String(arrT);

            if(newS.equals(newT))
                return true;
            return false;

    }
}
