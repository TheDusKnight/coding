package OOD_2004.Poke;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final long id;
    private final String name;
    private final List<Card> handCards;

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
        this.handCards = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCard(Card card) {
        if (card == null) return false;

        handCards.add(card);
        return true;
    }

    public Card popCard(int idx) {
        if (handCards.size() == 0) return null;
        if (idx < 0 || idx >= handCards.size()) return null;

        return handCards.remove(idx);
    }
}

