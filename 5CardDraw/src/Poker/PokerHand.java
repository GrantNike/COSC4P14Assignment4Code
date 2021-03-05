package Poker;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
//JAVA
import java.util.ArrayList;
//Project Files
import cards.card;

public class PokerHand {
    ArrayList<card> cards;

    public PokerHand(ArrayList<card> cards){
        this.cards = cards;
    }

    public void replaceCard(Integer index, card card){
        cards.set(index,card);
    }
    
    public ArrayList<card> getCards(){
        return cards;
    }
}
