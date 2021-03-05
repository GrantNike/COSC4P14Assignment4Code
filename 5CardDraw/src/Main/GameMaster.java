package Main;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
//JAVA
import java.util.ArrayList;
import java.util.Scanner;
//Project Files
import Poker.Dealer;
import Poker.HandRanker;
import Poker.HandType;
import Poker.PokerPlayer;
import cards.card;
import Poker.Player;
import Poker.PokerHand;

public class GameMaster {
    Dealer dealer;
    ArrayList<Player> players;
    HandRanker ranker;
    Boolean Done;
    Boolean[] selected;
    Scanner input;
    final String HEART = "\u2665";
    final String CLUB = "\u2663";
    final String DIAMOND = "\u2666";
    final String SPADE = "\u2660";

    public void run() {
        PokerPlayer player1 = new PokerPlayer();
        players = new ArrayList<>();
        players.add(player1);
        dealer = new Dealer();
        ranker = new HandRanker();
        input = new Scanner(System.in);
        Done = false;

        while (!Done) {
            dealer.shuffle();
            for (Player player : players) {
                PokerHand hand = dealer.dealHand();
                player.receiveHand(hand);
                System.out.print("Initial Hand: ");
                String temp = printHand(hand);
                selected = promptUser(temp);
                player.receiveHand(dealer.redraw(player.getHand(), selected));
                System.out.print("Final Hand: ");
                PokerHand playerHand = player.getHand();
                printHand(playerHand);
                System.out.println();
                HandType h = ranker.evaluateHand(playerHand);
                System.out.println("Your hand is a "+h);
            }
            Done = true;
        }
    }

    private void rankHand(Player player){

    }

    private Boolean[] promptUser(String temp){
        String[] str = temp.split(" ");
        Boolean[] selected = new Boolean[5];
        int i = 0;
        while(i<5){
            System.out.print("Keep "+str[i]+"? (Y/N): ");
            String choice = input.nextLine();
            if(choice.toLowerCase().equals("n")){
                selected[i] = true;
                i++;
            }
            else if(choice.toLowerCase().equals("y")){
                selected[i] = false;
                i++;
            }
            else{
                System.out.println("Incorrect input. Input should be y for yes or n for no.");
                continue;
            }
        }
        return selected;
    }

    private String printHand(PokerHand hand){
        ArrayList<card> cards = hand.getCards();
        String temp= "";
        for(card card:cards){
            temp+=card.getRank();
            switch (card.getSuit()){
                case CLUBS:
                    temp+=CLUB;
                    temp+=" ";
                break;
                case DIAMONDS:
                    temp+=DIAMOND;
                    temp+=" ";
                break;
                case HEARTS:
                    temp+=HEART;
                    temp+=" ";
                break;
                case SPADES:
                    temp+=SPADE;
                    temp+=" ";
                break;
            }
        }
        System.out.println(temp);
        return temp;
    }
}
