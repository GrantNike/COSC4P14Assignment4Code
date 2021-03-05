package tests;

import Poker.HandRanker;
import Poker.HandType;
import Poker.PokerHand;
import cards.Rank;
import cards.Suit;
import cards.card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandRankerTest {
    HandRanker ranker = new HandRanker();

    @Test
    void straightFlush() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.HEARTS));
        cards.add(new card(Rank.KING,Suit.HEARTS));
        cards.add(new card(Rank.QUEEN,Suit.HEARTS));
        cards.add(new card(Rank.JACK,Suit.HEARTS));
        cards.add(new card(Rank.TEN,Suit.HEARTS));
        assertEquals(HandType.STRAIGHT_FLUSH,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void flush() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.DIAMONDS));
        cards.add(new card(Rank.FOUR,Suit.DIAMONDS));
        cards.add(new card(Rank.EIGHT,Suit.DIAMONDS));
        cards.add(new card(Rank.SIX,Suit.DIAMONDS));
        cards.add(new card(Rank.TWO,Suit.DIAMONDS));
        assertEquals(HandType.FLUSH,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void straight() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.DIAMONDS));
        cards.add(new card(Rank.KING,Suit.HEARTS));
        cards.add(new card(Rank.QUEEN,Suit.SPADES));
        cards.add(new card(Rank.JACK,Suit.CLUBS));
        cards.add(new card(Rank.TEN,Suit.HEARTS));
        assertEquals(HandType.STRAIGHT,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void fullHouse() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.ACE,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.DIAMONDS));
        cards.add(new card(Rank.FOUR,Suit.SPADES));
        assertEquals(HandType.FULL_HOUSE,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void fourOfAKind() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.DIAMONDS));
        cards.add(new card(Rank.FOUR,Suit.SPADES));
        assertEquals(HandType.FOUR_OF_A_KIND,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void threeOfAKind() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.THREE,Suit.HEARTS));
        cards.add(new card(Rank.THREE,Suit.DIAMONDS));
        cards.add(new card(Rank.THREE,Suit.SPADES));
        assertEquals(HandType.THREE_OF_A_KIND,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void twoPair() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.THREE,Suit.DIAMONDS));
        cards.add(new card(Rank.THREE,Suit.SPADES));
        assertEquals(HandType.TWO_PAIR,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void pair() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.SEVEN,Suit.DIAMONDS));
        cards.add(new card(Rank.KING,Suit.SPADES));
        assertEquals(HandType.PAIR,ranker.evaluateHand(new PokerHand(cards)));
    }
    @Test
    void highCard() {
        ArrayList<card> cards = new ArrayList<card>();
        cards.add(new card(Rank.ACE,Suit.CLUBS));
        cards.add(new card(Rank.FOUR,Suit.HEARTS));
        cards.add(new card(Rank.JACK,Suit.HEARTS));
        cards.add(new card(Rank.SEVEN,Suit.DIAMONDS));
        cards.add(new card(Rank.KING,Suit.SPADES));
        assertEquals(HandType.HIGH_CARD,ranker.evaluateHand(new PokerHand(cards)));
    }
}