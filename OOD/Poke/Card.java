package OOD_2004.Poke;

public class Card implements Comparable<Card>{
    private final int val;
    private final Suit suit;

    public Card(int val, Suit suit) {
        this.val = val;
        this.suit = suit;
    }

    public int getValue() {
        return val;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        if (val == o.val) {
            return suit.getSuitValue() - o.suit.getSuitValue();
        }
        return val - o.val;
    }


}
