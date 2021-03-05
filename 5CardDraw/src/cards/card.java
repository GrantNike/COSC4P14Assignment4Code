package cards;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
public class card{
    Rank rank;
    Suit suit;

    public card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank(){
        return rank;
    }
    public Suit getSuit(){
        return suit;
    }
}
