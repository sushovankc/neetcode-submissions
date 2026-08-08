class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        q.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int elem = 0;elem<size;elem++){
                String cur = q.poll();
                for(int i = 0; i < cur.length();i++){
                    for(int j = 0; j < 26;j++){
                        if((char) (97+j) != cur.charAt(i)){
                            String ns =replaceChar(cur,(char) (97+j),i);
                            if(ns.equals(endWord)){
                                return steps+1;
                            } else if(set.contains(ns)){
                                q.add(ns);
                                set.remove(ns);
                            }
                        }
                    }
                }
            }
            steps++;
        }

        return 0;

    }

    public String replaceChar(String str, char newChar, int index){
        String newStr = str.substring(0, index) + newChar + str.substring(index + 1);
        return newStr;
    }

}
