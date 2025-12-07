package KunalKushwaha.Assignments.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DesignTwitter {
	Twitter twitter;
    public DesignTwitter() {
		twitter = new Twitter();
    }
	
	public class Twitter {
		Map<Integer, List<Integer>> userMap;
		LinkedList<Tweets> timeLine;

		class Tweets{
			int tweetId, userId;
			public Tweets(int userId, int tweetId){
				this.userId = userId;
				this.tweetId = tweetId;
			}

            @Override
                public String toString() {
                    return tweetId + " " + userId;
                }
			
		}
		public Twitter() {
			userMap = new HashMap<>();
			timeLine = new LinkedList<>();
		}
		
		public void postTweet(int userId, int tweetId) {
            userMap.putIfAbsent(userId, new ArrayList<>());
            
            // Ensure user follows themselves (to see own tweets)
            if (!userMap.get(userId).contains(userId)) {
                userMap.get(userId).add(userId);
            }
			timeLine.addFirst(new Tweets(userId, tweetId));
		}
		
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> newsFeed = new ArrayList<>();
            if (!userMap.containsKey(userId)) return newsFeed;
			List<Integer> following = userMap.get(userId);
			for (Tweets t : timeLine) {
                if (following.contains(t.userId)) {
                    newsFeed.add(t.tweetId);
                }
                if (newsFeed.size() == 10) break;
            }
			return newsFeed;
		}
		
		public void follow(int followerId, int followeeId) {
            userMap.putIfAbsent(followerId, new ArrayList<>());

            List<Integer> following = userMap.get(followerId);

            // Always follow yourself
            if (!following.contains(followerId)) {
                following.add(followerId);
            }
			// Follow followee
            if (!following.contains(followeeId)) {
                following.add(followeeId);
            }

		}
		
		public void unfollow(int followerId, int followeeId) {
			if (!userMap.containsKey(followerId)) return;

            if (followerId == followeeId) return; // Cannot unfollow yourself

            List<Integer> following = userMap.get(followerId);
            following.remove(Integer.valueOf(followeeId));
		}

		public void timeLine(){
			for(Tweets tweets: timeLine){
				System.out.println(tweets.toString());
			}
		}
	}
	public static void main(String[] args) {
		DesignTwitter dt = new DesignTwitter();
		Twitter twitter = dt.twitter;

		twitter.postTweet(1, 5);
		twitter.getNewsFeed(1);
		twitter.timeLine();
	}
}
