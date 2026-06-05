class Twitter {
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    List<int[]> tweetList = new ArrayList<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new int[] {userId, tweetId});
        followMap.computeIfAbsent(userId, x -> new HashSet<>());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        int n = tweetList.size();

        for (int i = n-1; i >= 0; i--) {
            int[] tweet = tweetList.get(i);

            if (tweet[0] == userId || followMap.get(tweet[0]).contains(userId)) {
                result.add(tweet[1]);
            }

            if (result.size() == 10) {
                break;
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, x -> new HashSet<>());
        followMap.computeIfAbsent(followeeId, x -> new HashSet<>()).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followeeId).remove(followerId);
    }
}
