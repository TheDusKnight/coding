package OOD_2004.Poke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
   List<Card> cards;
   Random rand;
   
   public Deck() {
        rand = new Random();
        cards = new ArrayList<>();
        init();
   }

   private void init() {
        cards.clear();

       for (Suit suit: Suit.values()) {
           for (int i = 2; i < 14; i++) {
               cards.add(new Card(i, suit));
           }
       }
   }

   public void shuffle() {
       for (int i = 0; i < cards.size(); i++) {
           final int randIdx = rand.nextInt(cards.size() - i) + i;
           final Card tmp = cards.get(i);

           // swap
           cards.set(i, cards.get(randIdx));
           cards.set(randIdx, tmp);
       }
   }

   public Card deal() {
       if (cards.isEmpty()) return null;

       return cards.remove(cards.size() - 1);
   }

   public List<Card> deal(int num) {
       List<Card> tmp = new ArrayList<>();
       for (int i = 0; i < num; i++) {
           tmp.add(deal());
       }
       return tmp;
   }
}
