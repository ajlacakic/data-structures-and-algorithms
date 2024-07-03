package homework4;

import java.util.*;

public class SocialNetwork {
    private Map<String, List<Friendship>> adjacencyList = new HashMap<>();

    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(Friendship f) {
        adjacencyList.get(f.getFriend1()).add(f);
        adjacencyList.get(f.getFriend2()).add(f);
    }

    public List<FriendshipRecommendation> recommendFriends(String user) {
        if (!adjacencyList.containsKey(user)) {
            return new ArrayList<>();
        }

        Map<String, Integer> recommendationStrengths = new HashMap<>();


        List<Friendship> directFriends = adjacencyList.get(user);

        for (Friendship directFriendship : directFriends) {

            String directFriend = directFriendship.getFriend2().equals(user) ? directFriendship.getFriend1() : directFriendship.getFriend2();


            if (adjacencyList.containsKey(directFriend)) {
                for (Friendship friendOfFriendship : adjacencyList.get(directFriend)) {
                    String friendOfFriend = friendOfFriendship.getFriend2().equals(directFriend) ? friendOfFriendship.getFriend1() : friendOfFriendship.getFriend2();


                    if (!friendOfFriend.equals(user) && !containsFriend(directFriends, friendOfFriend)) {
                        int currentStrength = Math.min(directFriendship.getFriendshipStrength(), friendOfFriendship.getFriendshipStrength());
                        recommendationStrengths.put(friendOfFriend, recommendationStrengths.getOrDefault(friendOfFriend, 0) + currentStrength);
                    }
                }
            }
        }


        List<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendationStrengths.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }


        Collections.sort(recommendations);
        return recommendations;
    }


    private boolean containsFriend(List<Friendship> friends, String potentialFriend) {
        for (Friendship friendship : friends) {
            if (friendship.getFriend1().equals(potentialFriend) || friendship.getFriend2().equals(potentialFriend)) {
                return true;
            }
        }
        return false;
    }

}

