package cards;
/*
Grant Nike
6349302
COSC 3P91 Assignment #2
March 6th
*/
import java.util.ArrayList;

public interface Deck {
    public void initialize();
    public card next();
    public ArrayList<card> next(int n);
    public void shuffle();
}
