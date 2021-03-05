package Poker;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
import java.util.ArrayList;

import cards.StandardDeck;
import cards.card;

public class Dealer {
    StandardDeck deck;

    public Dealer(){
        deck = new StandardDeck();
    }

    public void shuffle(){
        deck.shuffle();
    }

    public void burnCard(){
        deck.next();
    }

    public PokerHand dealHand(){
        ArrayList<card> cards = new ArrayList<>();
        for(int i=0;i<5;i++){
            cards.add(deck.next());
        }
        PokerHand hand = new PokerHand(cards);
        return hand;
    }

    public PokerHand redraw(PokerHand old_hand,Boolean[] selected){
        PokerHand new_hand = old_hand;
        for (int i=0;i<5;i++){
            if (selected[i]){
                new_hand.replaceCard(i,deck.next());
            }
        }
        return new_hand;
    }
}
