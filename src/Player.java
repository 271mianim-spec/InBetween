import java.util.Scanner;

public class Player {
    public static int money;
    public static int bet;

    public static boolean quit;

    public static Deck deck;

    public static void main(String[] args) {
        money = 100;
        quit = false;

        deck =  new Deck();
        deck.shuffle();

        while(quit == false){
            if (deck.numCards() < 10) {
                deck = new Deck();
                deck.shuffle();
            }

            setBet();
            boolean victory = round();
            if (victory) {
                money = money + bet*2;
            }

            if (money <= 0) {
                System.out.println("You have gone bankrupt!");
                System.exit(0);
            }
        }




    }

    public static void setBet() {
        System.out.println("You have $"+money);
        String betAsString = getInput("How much do you want to bet? > ");

        try {
            bet = Integer.parseInt(betAsString);
        } catch (Exception e) {
            System.out.println("Invalid Bet!");
            setBet();
        }

        if (bet <= 0 || bet > money) {
            System.out.println("You cannot bet this much!");
            setBet();
        }

    }

    public static void handleDouble() {
        String willDouble = getInput("Do you wish to double? (Y/N) > ");
        if (willDouble.equalsIgnoreCase("Y")) {
            bet = bet*2;
            System.out.println("The new bet is $"+bet);
        } else if (willDouble.equalsIgnoreCase("N")) {
            System.out.println("The bet is currently $"+bet);
        } else {
             handleDouble();
             return;
        }
    }

    public static String insideOrOutside() {
        String answer = getInput("Inside or Outside? (inside/outside) > ");
        if (answer.equalsIgnoreCase("inside") || answer.equalsIgnoreCase("outside")) {
            return answer.toLowerCase();
        } else {
            return insideOrOutside();
        }
    }

    public static boolean round() {
        Card card1 = deck.drawRandomCard();
        Card card2 = deck.drawRandomCard();



        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);

        if (card1.getValue() == card2.getValue()) {
            System.out.println("Both card values are the same, so you win!");
            return true;
        }

        if (Math.abs(card1.getValue() - card2.getValue()) == 1) {
            System.out.println("The difference between the two cards is 1, so you lose");
            return false;
        }

        Card higherCard;
        Card lowerCard;
        if (card1.getValue() > card2.getValue()) {
            higherCard = card1;
            lowerCard = card2;
        } else {
            higherCard = card2;
            lowerCard = card1;
        }

        if (bet*2<=money) {
            handleDouble();
        }

        money -= bet;

        String answer = insideOrOutside();

        Card decidingCard = deck.drawRandomCard();
        boolean isInside = false;
        if (decidingCard.getValue() < higherCard.getValue() && decidingCard.getValue() > lowerCard.getValue()) {
            isInside = true;
        }

        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
        System.out.println("Pulled Card: " + decidingCard);

        if (decidingCard.getValue() == card1.getValue() || decidingCard.getValue() == card2.getValue()) {
            System.out.println("The new card shares a value with one of the first two cards. You lose.");
            return false;
        }


        if (answer.equalsIgnoreCase("inside") && isInside) {
            System.out.println("The new card was inside! You win!");
            return true;
        } else if (answer.equalsIgnoreCase("outside") && !isInside) {
            System.out.println("The new card was outside! You win!");
            return true;
        } else {
            String outsideOrInsideText = "outside";
            if (isInside) {
                outsideOrInsideText = "inside";
            }

            System.out.println("The new card was "+outsideOrInsideText+". You lose");
            return false;
        }

    }

    public static String getInput(String question) {
        Scanner input = new Scanner(System.in);
        System.out.print(question);
        return input.nextLine();
    }
}
