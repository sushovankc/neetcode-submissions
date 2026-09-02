class Twitter {

    class Tweet{
        int time;
        int tweetId;

        Tweet(int time,int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<Tweet>> tweetsMap;
    int timeStamp;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetsMap = new HashMap<>();
        this.timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {

        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(timeStamp++,tweetId));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        Queue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> b.time - a.time);

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if(followMap.containsKey(userId)){
            users.addAll(followMap.get(userId));
        }

        for(int uid: users){
            List<Tweet> tweets = tweetsMap.getOrDefault(uid,new ArrayList<>());
            for(Tweet tweet : tweets){
                maxHeap.add(tweet);
            }
        }

        List<Integer> results = new ArrayList<>();

        int cnt = 0;
        while(!maxHeap.isEmpty() && cnt < 10){
            results.add(maxHeap.poll().tweetId);
            cnt++;
        }

        return results;
        
    }
    
    public void follow(int followerId, int followeeId) {

        if(followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }   
    }
}
