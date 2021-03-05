package Poker;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
public abstract class Player {
    double money;
    PokerHand hand;

    public abstract PokerHand getHand();
    public abstract void receiveHand(PokerHand hand);
}
