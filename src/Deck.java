import java.util.ArrayList;
// Javadocs!
public class Deck
{
   private ArrayList<Card> cards;

    /**
     * Creates a new deck with the classic blackjack deck of cards.
     */
   public Deck() {
       
       cards = new ArrayList<Card>();
       
       String[][] prelist = {
           {"Spades", "Diamonds", "Clubs", "Hearts"},
           {"King", "Queen", "Jack", "Ten", "Nine", "Eight","Seven","Six","Five","Four","Three","Two","Ace"}
       };
       
       for (int i = 0; i < prelist[0].length; i++) {
            if (i < 2) {
                
                for (int j = prelist[1].length-1; j >= 0; j--) {
                    cards.add(
                        new Card(prelist[0][i], prelist[1][j])
                    );
                }
                
            } else {
                
                for (int j = 0; j < prelist[1].length; j++) {
                    cards.add(
                        new Card(prelist[0][i], prelist[1][j])
                    );
                }
                
            }
       }
   }
   
   /**
     * Picks the last card in the deck and removes it from the deck
     * 
     * Precondition: there is atleast one card in the deck
     * 
     * @return Card the chosen card
     */
   public Card drawCard() {
       Card chosenCard = cards.get(0);
       cards.remove(chosenCard);
       return chosenCard;
   }
   
   /**
     * Picks a random card in the deck and removes it from the deck
     * 
     * Precondition: there is atleast one card in the deck
     * 
     * @return Card the chosen card
     */
   public Card drawRandomCard() {
       int random = (int) Math.round((Math.random()*(cards.size()-1)));
       Card chosenCard = cards.get(random);
       cards.remove(chosenCard);
       return chosenCard;
   }
   
   /**
     * Returns an int of how many cards are in the deck
     * 
     * @return int number of cards in the deck
     */
   public int numCards() {
       return cards.size();
   }
   
   /**
     * Returns the deck's ArrayList of Card objects
     * 
     * @return ArrayList<Card> the card deck
     */
   public ArrayList<Card> getDeck() {
       return cards;
   }
   
    /**
     * Returns a nicely formatted version of the deck
     * based on all the card's toString
     * 
     * @return String a string representation of the deck
     */
   public String toString() {
       String str = "";
       str += "Deck of "+numCards() + " Cards {\n";
       for (Card crd : cards) {
           str += " • "+crd.toString()+"\n";
       }
       str += "}";
       return str;
   }
   
   /**
     * Shuffles all the cards in the deck, putting them in a random order.
     * 
     * Precondition: there is atleast one card in the deck
     */
   public void shuffle() {
        ArrayList<Card> newDeck = new ArrayList<Card>();
        while (cards.size() > 0) {
            Card crd = drawRandomCard();
            newDeck.add(crd);
        }
        cards = newDeck;
   }
   
}