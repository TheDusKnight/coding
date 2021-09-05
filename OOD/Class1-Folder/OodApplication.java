import Class1.InterFaceDemo1.*;
import Class1.Poker.Card;
import Class1.Poker.Deck;
import Class1.Poker.Suit;
import Class1.Poker.TexasPoker.Pattern;
import Class1.Poker.TexasPoker.PatternManager;
import Class1.Poker.TexasPoker.PatternValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FLK on 2020-06-13.
 */
public class OodApplication {
    public static void main(String[] argus){
        //-------------------------------------------------//

        final Person person = new Person("Frank", "1");


        final Book book = new Book();
        final NewsPaper newsPaper = new NewsPaper();
        final Magzine magzine = new Magzine();
        final Noval noval = new Noval();

        person.read(book);
        person.read(newsPaper);
        person.read(magzine);
        person.read(noval);



        //-------------------------------------------------//

        for(int i = 0; i < 10; i++) {
            final Deck deck = new Deck();

//            deck.init();
//            deck.shuffle();

            List<Card> cards1 = new ArrayList<Card>(Arrays.asList(new Card(Suit.Spade, 9), new Card(Suit.Spade, 13), new Card(Suit.Spade, 12), new Card(Suit.Spade, 11), new Card(Suit.Spade, 10)));
            List<Card> cards2 = new ArrayList<Card>(Arrays.asList(new Card(Suit.Spade, 9), new Card(Suit.Spade, 9), new Card(Suit.Spade, 6), new Card(Suit.Spade, 7), new Card(Suit.Spade, 5)));

//            for(int j = 0; j < 5; j++){
//                cards1.add(deck.dealCard());
//                cards2.add(deck.dealCard());
//            }

            PatternManager patternManager = PatternManager.getInstance();

            Pattern pattern1 = patternManager.getPattern("123", cards1);
            Pattern pattern2 = patternManager.getPattern("234", cards2);

            if (pattern1.compareTo(pattern2) > 0) {
                System.out.println(String.format("Pattern 1 is larger: Pattern1 is a %s and Pattern2 is a %s", pattern1.getPatternValue().getPatternName(), pattern2.getPatternValue().getPatternName()));
            } else {
                System.out.println(String.format("Pattern 2 is larger: Pattern1 is a %s and Pattern2 is a %s", pattern1.getPatternValue().getPatternName(), pattern2.getPatternValue().getPatternName()));
            }
        }

            System.out.println("Test :" + PatternValues.Flush);


        //-------------------------------------------------//




        //-------------------------------------------------//




        //-------------------------------------------------//
    }
}
