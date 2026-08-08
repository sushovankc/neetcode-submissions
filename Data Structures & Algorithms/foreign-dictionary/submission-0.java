class Solution {
    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj = new ArrayList<>();
      int[] indegree = new int[26];
      boolean[] exists = new boolean[26];

      for(int i = 0;i<26;i++){
        adj.add(new ArrayList<>());
      }

      for(String s : words){
        for(char c:s.toCharArray()){
            exists[c-'a'] = true;
        }
      }

      for(int i = 0;i < words.length - 1;i++){
        String first = words[i];
        String second = words[i+1];

        int minLen = Math.min(first.length(),second.length());

        if(first.length() > second.length() && first.startsWith(second)){
            return "";
        }

        for(int j = 0;j<minLen;j++){
            if(first.charAt(j) != second.charAt(j)){
                adj.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                indegree[second.charAt(j)-'a']++;
                break;
            }
        }
      }

      Queue<Integer> q = new LinkedList<>();
      String res = "";

      for(int i = 0;i < 26;i++){
        if(indegree[i] == 0 && exists[i]){
            q.add(i);
        }
      }

      while(!q.isEmpty()){
        int node = q.poll();
        res += (char)(node + 'a');

        for(int neighbor : adj.get(node)){
            indegree[neighbor]--;
            if(indegree[neighbor] == 0){
                q.add(neighbor);
            }
        }
      }

      int totalChars = 0;

      for(boolean b : exists){
        if(b) totalChars++;
      }

      return res.length() == totalChars?res:"";
    }
}
