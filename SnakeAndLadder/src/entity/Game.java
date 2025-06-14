package entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayerIdx;

    public Game() {
        players = new ArrayList<>();
        currentPlayerIdx=0;
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    public void notifyPlayers(String msg) {
        for(Player player: players) {
            player.update(msg);
        }
    }

    public void nextTurn() {
        currentPlayerIdx = (currentPlayerIdx+1) % players.size();
    }
}
