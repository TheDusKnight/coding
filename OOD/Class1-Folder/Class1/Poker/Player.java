package Class1.Poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final String name;

    private final List<Card> handCards;

    public Player(final int id, final String name){
        this.id = id;
        this.name = name;
        handCards = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCard(final Card card){
        if(card == null) return false;

        handCards.add(card);
        return true;
    }

    public Card popCard(final int index){
        if(index < 0 || index >= handCards.size()) return null;

        return handCards.remove(index);
    }

    public List<Card> showHand(){
        return handCards;
    }
}
