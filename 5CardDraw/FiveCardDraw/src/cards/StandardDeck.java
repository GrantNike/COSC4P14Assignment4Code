package cards;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
import java.util.ArrayList;
import java.util.Collections;

public class StandardDeck {
    ArrayList<card> cards;
    //Deck initializes itself when it is created 
    public StandardDeck(){
        initialize();
    }
    //Initialize creates the 
    public void initialize(){
        cards = new ArrayList<>();
        for (Suit s: Suit.values()){
            for (Rank r: Rank.values()){
                card card = new card(r,s);
                cards.add(card);
            }
        }
    }

    public card next(){
        return cards.remove(0);
    }

    public ArrayList<card> next(int n){
        ArrayList<card> hand = new ArrayList<>();
        for (int i=0;i<n;i++){
            hand.add(next());
        }
        return hand;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
