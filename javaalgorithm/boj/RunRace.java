import java.util.*;
class RunRace {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> rankMap = new HashMap<>();
        for(int i=0; i< players.length; i++){
            rankMap.put(players[i], i);
        }

        for (String player : callings) {
            int ownRank = rankMap.get(player);
            String beforePlayer = players[ownRank-1];

            players[ownRank-1] = player;
            players[ownRank] = beforePlayer;

            rankMap.put(player, ownRank-1);
            rankMap.put(beforePlayer, ownRank);
        }

        return players;
    }
}
