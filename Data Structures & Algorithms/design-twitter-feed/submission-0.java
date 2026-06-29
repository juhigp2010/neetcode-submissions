class Twitter {
    private static int timestamp = 0;
    private static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private Map<Integer, Set<Integer>> followersMap;
    private Map<Integer, Tweet> tweetsMap;
    public Twitter() {
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        // Insert the new tweet at the head of the user's tweet linked list
        newTweet.next = tweetsMap.get(userId);
        tweetsMap.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followees = followersMap.get(userId);
        
        if (followees == null || followees.isEmpty()) {
            return feed;
        }
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int followeeId : followees) {
            Tweet t = tweetsMap.get(followeeId);
            if (t != null) {
                maxHeap.add(t);
            }
        }
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet curr = maxHeap.poll();
            feed.add(curr.id);
            count++;
            if (curr.next != null) {
                maxHeap.add(curr.next);
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(followeeId);
        }
    }
}
