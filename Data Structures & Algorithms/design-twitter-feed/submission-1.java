class Twitter {

    // map followee to followers
    Map<Integer, Set<Integer>> followersMap = new HashMap<>();
    List<int[]> tweetList = new ArrayList<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new int[] {userId, tweetId});
        followersMap.computeIfAbsent(userId, x -> new HashSet<>());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        int n = tweetList.size();

        for (int i = n-1; i >= 0; i--) {
            int[] tweet = tweetList.get(i);
            
            if (tweet[0] == userId || followersMap.get(tweet[0]).contains(userId)) {
                result.add(tweet[1]);

                if (result.size() == 10) {
                    return result;
                }
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followeeId, x -> new HashSet<>()).add(followerId);
        followersMap.computeIfAbsent(followerId, x -> new HashSet<>());
    }
    
    public void unfollow(int followerId, int followeeId) {
        followersMap.get(followeeId).remove(followerId);
    }
}
