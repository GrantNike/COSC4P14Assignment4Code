package Poker;

import java.util.ArrayList;

import cards.card;

/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
public class HandRanker {
    public int compare(PokerHand hand1,PokerHand hand2){
        return 0;
    }

    private int highestRank;
    private int groupOfMatchingCards1,groupOfMatchingCards2;
    private int firstGroupRank,secondGroupRank;
    //Returns the hand type of a given poker hand
    public HandType evaluateHand(PokerHand hand){
        int[] ranks = new int[14];
        int[] cardRanks = getCardRanks(hand.getCards());
        
        Boolean flush;
        Boolean straight;
        //Increment index of matching rank 
        for(int i=0;i<5;i++){
            ranks[cardRanks[i]]++;
        }
        checkMatchingCards(ranks);
        flush = hasFlush(hand.getCards());
        straight = hasStraight(ranks);

        if(flush){
            if(straight){
                return HandType.STRAIGHT_FLUSH;
            }
            //else if(){}
            else{
                return HandType.FLUSH;
            }
        }
        else if(straight){
            return HandType.STRAIGHT;
        }
        //If their are matching cards, check for pair, two pair, three of a kind, four of a kind, and full house
        else if(groupOfMatchingCards1>1){
            if(groupOfMatchingCards1==2){
                if(groupOfMatchingCards2==2){
                    return HandType.TWO_PAIR;
                }
                else if(groupOfMatchingCards2==3){
                    return HandType.FULL_HOUSE;
                }
                else{
                    return HandType.PAIR;
                }
            }
            else if(groupOfMatchingCards1==3){
                if(groupOfMatchingCards2==2){
                    return HandType.FULL_HOUSE;
                }
                else{
                    return HandType.THREE_OF_A_KIND;
                }
            }
            else if(groupOfMatchingCards1==4){
                return HandType.FOUR_OF_A_KIND;
            }
        }
        return HandType.HIGH_CARD;
    }
    private Boolean hasStraight(int[] ranks){
        highestRank = 0;
        Boolean straight = false;
        //If there are five cards with consecutive ranks then there is a straight
        //Only treats Ace as lowest card
        for(int i=1;i<10;i++){
            if (ranks[i]==1 && ranks[i+1]==1 && ranks[i+2]==1 && ranks[i+3]==1 && ranks[i+4]==1){
                straight = true;
                highestRank = i+4;
                break;
            }
        }
        //Covers case of Ace as highest card
        if(ranks[10]==1 && ranks[11]==1 && ranks[12]==1 && ranks[1]==1){
            straight = true;
            highestRank = 14;
        }
        return straight;
    }
    //Helper method for evaluate hand
    //Checks hand for a flush
    private boolean hasFlush(ArrayList<card> cards){
        boolean flush = true;
        for (int i=0;i<4;i++){
            if(cards.get(i).getSuit() !=cards.get(i+1).getSuit())
                flush = false;
        }
        return flush;
    }
    //Helper method for evaluate hand
    //Checks for groups of matching card ranks in hand, can find 2 pair, 3 of a kind, 4 of a kind, and a full house 
    private void checkMatchingCards(int[] ranks){
        firstGroupRank=0;
        secondGroupRank=0;
        groupOfMatchingCards1=1;
        groupOfMatchingCards2=1;
        for (int i=13; i>=1; i--){
            if (ranks[i] > groupOfMatchingCards1){
                if (groupOfMatchingCards1 != 1){
                //Ensures first group does not get overwritten by a second group
                    groupOfMatchingCards2 = groupOfMatchingCards1;
                    secondGroupRank = firstGroupRank;
                }
                
                groupOfMatchingCards1 = ranks[i];
                firstGroupRank = i;
                
            }
            else if (ranks[i] > groupOfMatchingCards2){
                groupOfMatchingCards2 = ranks[i];
                secondGroupRank = i;
            }
        }
    }
    //Helper method for evaluate hand
    //Get rank values of cards to integers
    private int[] getCardRanks(ArrayList<card> cards){
        int[] cardRanks = new int[5];
        int i = 0;
        for(card card:cards){
            switch(card.getRank()){
                case ACE:
                    cardRanks[i] = 1;
                    break;
                case EIGHT:
                    cardRanks[i] = 8;
                    break;
                case FIVE:
                    cardRanks[i] = 5;
                    break;
                case FOUR:
                    cardRanks[i] = 4;
                    break;
                case JACK:
                    cardRanks[i] = 11;
                    break;
                case KING:
                    cardRanks[i] = 13;
                    break;
                case NINE:
                    cardRanks[i] = 9;
                    break;
                case QUEEN:
                    cardRanks[i] = 12;
                    break;
                case SEVEN:
                    cardRanks[i] = 7;
                    break;
                case SIX:
                    cardRanks[i] = 6;
                    break;
                case TEN:
                    cardRanks[i] = 10;
                    break;
                case THREE:
                    cardRanks[i] = 3;
                    break;
                case TWO:
                    cardRanks[i] = 2;
                    break;
            }
            i++;
        }
        return cardRanks;
    }
}
