package Class1.Poker;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;

    private final Deck deck;

    private final String id;

    public Game(final String id){
        this.id = id;
        players = new ArrayList<Player>();
        deck = new Deck();
    }

    public boolean init(){
        if(players.size() <= 1) return false;

        deck.init();
        deck.shuffle();

        while(deck.getSize() > 0){

            for(Player player : players){
                player.getCard(deck.dealCard());
            }
        }

        return true;
    }

    public void compare(List<Player> othrePlayers){
        //sdofsoifjoiej  1000 lines

        //players = othrePlayers;

        // 500 lines
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getPlayer(int index){
        if(index < 0 || index >= players.size()) return  null;

        return players.get(index);
    }

    public String getId(){
        return id;
    }

    public boolean isOver(){
        for(Player player : players){
            if(player.showHand().isEmpty()){
                return true;
            }
        }

        return false;
    }
}
