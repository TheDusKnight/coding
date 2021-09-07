package Class1.Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        init();
    }

    public void init() {
        cards.clear();
        for(int i = 2; i <= 14; i++) {
            for(Suit suit : Suit.values()) { // set形式遍历
                cards.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        for(int i = 0; i < cards.size(); i++) {
            final int randIndex = new Random().nextInt(i + 1);
            final Card tempCard = cards.get(i);

            //Swap in list
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, tempCard);
        }
    }

    public int getSize(){
        return cards.size();
    }

    public Card dealCard() {
        if (cards.isEmpty()) return null;

        final int size = cards.size();

        return cards.remove(size - 1);
    }

    public Card peek() {
        if(cards.isEmpty()) return null;
        return cards.get(cards.size() - 1);
    }

}
