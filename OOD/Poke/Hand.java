import java.util.List;

import OOD.Poke.Card;

public class Hand {
    public Integer score(List<Card> cards) {
        if (cards == null) return null;

        int res = 0;
        boolean hasA = false;
        for (Card card: cards) {
            int cur = card.getValue();
            if (cur == 11 || cur == 12 || cur == 13)
                res += 10;
            else if (cur == 1) {
                hasA = true;
                res += cur;
            }
            else res += cur;
        }

        return hasA && res + 10 <= 21 ? res + 10 : res;
    }
}
