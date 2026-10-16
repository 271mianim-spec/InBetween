import javax.swing.*;
import java.awt.*;

//Don't forget to include Java Docs!!!
public class Card
{
    private String suit;
    private String rank;
    private int value;
    
    /**
     * Creates a new card object based on a provided suit and rank.
     * The card is automatically assigned a value based on it's rank.
     * 
     * Precondition: The card's rank is a proper rank, otherwise value is set to 0
     * 
     * @param String r the card's desired suit
     * @param String s the card's desired rank
     */
    public Card(String s, String r) {
        suit = s;
        rank = r;
        
        if (r.equals("Ace")) {
            value = 11;
        } else if (r.equals("Two")) {
            value = 2;
        } else if (r.equals("Three")) {
            value = 3;
        } else if (r.equals("Four")) {
            value = 4;
        } else if (r.equals("Five")) {
            value = 5;
        } else if (r.equals("Six")) {
            value = 6;
        } else if (r.equals("Seven")) {
            value = 7;
        } else if (r.equals("Eight")) {
            value = 8;
        } else if (r.equals("Nine")) {
            value = 9;
        } else if (r.equals("Ten")) {
            value = 10;
        } else if (r.equals("King")) {
            value = 10;
        } else if (r.equals("Queen")) {
            value = 10;
        } else if (r.equals("Jack")) {
            value = 10;
        } else {
            value = 0;
        }
    }
    
    /**
     * Returns the card's rank
     * 
     * @return String the card's rank
     */
    public String getRank() {
        return rank;
    }
    
    /**
     * Return's the card's filename to fetch an image.
     * 
     * @return String the card's filename
     */
    public String getCardImage() {
        String fileName = "CardImages/"+rank+suit+".png";
        return fileName;
    }
    
    /**
     * Returns the card's suit
     * 
     * @return String the card's suit
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * Returns the card's value, which is 
     * automatically assigned in the constructor
     * 
     * @return int the card's value
     */
    public int getValue() {
        return value;
    }
    
    /**
     * If the card's rank is "Ace", the value
     * will swap between 1 or 11, depending on
     * the card's current value.
     * 
     * Precondition: the card's rank is "Ace", does not do anything otherwise
     */
    public void switchValue() {
        if (rank.equals("Ace")) {
            if (value == 11) {
                value = 1;
            } else {
                value = 11;
            }
        }
    }
    
    /**
     * Returns a nicely formatted version of the card
     * containing the rank, value, and suit respectively
     * 
     * @return String a string representation of the card
     */
    public String toString() {
        return rank + " ("+value+") of "+suit;
    }
    
}