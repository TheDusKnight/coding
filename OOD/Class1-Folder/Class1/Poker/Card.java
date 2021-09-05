package Class1.Poker;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final int value;

    public Card(final Suit suit, final int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card c) {
        if(value == c.value) {
            return suit.getSuitValue() - c.suit.getSuitValue();
        }
        return value - c.value;
    }
}
