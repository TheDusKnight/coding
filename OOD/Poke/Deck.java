import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private final long id;
    private final List<Card> cards;
    Random rand;

    public Deck(long id) {
        this.id = id;
        cards = new ArrayList<>();
        rand = new Random();
        for (Suit suit: Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card(i, suit));
            }
        }
    }

    public Card deal() {
        if (cards.isEmpty()) return null;

        Card res = cards.remove(cards.size() - 1);
        return res;
    }

    public List<Card> deal(int num) {
        List<Cards> res = new ArrayList<>()
        for (int i = 0; i < num; i++) {
            res.add(deal());
        }
        return res;
    }

    public void shuffle() {
        
        for (int i = 0; i < cards.size(); i++) {
            int tmp = i + rand.nextInt(cards.size() - i);
            // swap(cards, i, tmp);
            Card card1 = cards.get(tmp);
            Card card2 = cards.get(i);
            cards.set(i, card1);
            cards.set(tmp, card2);
        }
    }
}
