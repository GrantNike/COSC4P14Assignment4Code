package Poker;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
public class PokerPlayer extends Player{
    double money;
    PokerHand hand;

    public PokerHand getHand(){
        return hand;
    }
    public void receiveHand(PokerHand hand){
        this.hand = hand;
    }
}
